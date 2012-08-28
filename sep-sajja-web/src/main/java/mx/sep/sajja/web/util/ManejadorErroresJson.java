package mx.sep.sajja.web.util;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.sep.sajja.servicios.util.BaseTipoError;
import mx.sep.seguridad.modelo.UsuarioSeguridad;
import mx.sep.seguridad.util.SeguridadUtil;

import org.apache.commons.beanutils.BeanMap;
import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;
import org.springframework.web.util.WebUtils;


/**
 * 
 *  Una extensión de {@link AbstractHandlerExceptionResolver} con las siguientes características:
 *  - Devuelve información del error en formato Json.
 *  - Se puede asignar un mecanismo de notificación a cada tipo de excepción configurada.
 *  - Se puede asignar una etiqueta arbitraria para indicar el nivel de gravedad de cada excepción.
 *
 *  El siguiente es un ejemplo de configuración típica.
 * <pre>
 * {@code
 *        <bean class="mx.sep.sajja.web.util.ManejadorErroresJson">
 *            <property name="mapeoExcepciones">
 *                <map>
 *                    <!-- Para asignar un notificador a una Excepción. Si no se establece un notificador
 *                    para una excepción más específica se elige el notificador de la super clase más cercana
 *                    en la jerarquía de herencia.-->
 *                    <entry key="mx.sep.sajja.servicios.util.ErrorNegocio" value-ref="notificacionLog"></entry>
 *
 *                    <!-- En este caso no se elige notificador. Si se especifica un servicioNotificaciónDefault
 *                    se usará este, de otro modo no se notificará el error. El error hacia presentación siempre
 *                    se genera.-->
 *                    <entry key="mx.sep.sajja.servicios.util.ErrorInfraestructura" value=""></entry>
 *    
 *                    <entry key="java.lang.RuntimeException" value=""></entry>
 *                </map>
 *            </property>
 *            <property name="mapeoNivelErrores">
 *                <map>
 *                    <!-- Se coloca en value el nivel del error generado. En realidad se puede colocar la
 *                    leyenda que se desee -->
 *                    <entry key="mx.sep.sajja.servicios.util.ErrorNegocio" value="ERROR DE NEGOCIO"></entry>
 *                    <entry key="mx.sep.sajja.servicios.util.ErrorInfraestructura" value="ERROR GRAVE"></entry>
 *                    <entry key="java.lang.RuntimeException" value="ERROR NO IDENTIFICADO"></entry>
 *                </map>
 *            </property>
 *            <property name="servicioNotificacionDefault" ref="notificacionLog" />
 *        </bean>
 *       <bean id="notificacionLog" class="mx.sep.sajja.web.util.ServicioNotificacionLog" />
 * }
 * </pre>
 *
 * @author Alejandro Pimentel 
 */
public class ManejadorErroresJson
        extends AbstractHandlerExceptionResolver implements ApplicationContextAware{

    @Autowired
    private MessageSource messageSource;
    
    private ApplicationContext ctx;

    public static final String CONTENT_TYPE = "text/plain;charset=UTF-8";

    public static final String NIVEL_DEFAULT = "ERROR";

    private JsonEncoding encoding = JsonEncoding.UTF8;

    private ServicioNotificacion servicioNotificacionDefault;

    private Map<Class<?>, Object> mapeoExcepciones;

    private Map<Class<?>, String> mapeoNivelErrores;

    private static final Logger log = LoggerFactory.getLogger(ManejadorErroresJson.class);

    private String[] filtrados = { "excepcion" };

    private Integer codigoErrorHttpDefualt = 503;

    private boolean esProfileDesarrollo;
    
    private String nombreProfileDesarrollo;

    /**
     * Resuelve una excepción generando un objeto con información del error,
     * en formato Json.
     *
     * El objeto contiene por defecto todos los campos de la clase {@link InformacionError},
     * excepto el campo excepción, esto reduce la información enviada al cliente.
     *
     * Posteriormente el método usa el objeto de notificación de error para enviar la
     * información del mismo a algún medio como: correo, archivo, syslog, etc.
     *
     * @param request
     * @param response
     * @param handler El objeto del cual provino la excepción. Por ejemplo un controller.
     * @param ex
     * @return Nunca retorna un objeto ModelAndView, la respuesta es escrita en el objeto response directamente.
     */
    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        if(log.isDebugEnabled()) {
            log.debug("Resolviendo mensaje JSON para excepción:" + ex.getClass().
                    getCanonicalName());
        }

        ObjectMapper mapper = new ObjectMapper();

        InformacionError info = prepararInformacionError(request, response, handler, ex);
        info.setNivelError(resolverNivelError(ex.getClass()));
        Map infoMap = prepararMapaInformacion(info);
        Map infoFiltrada = filtrarInfoError(infoMap);

        aplicarCódigoErrorHttp(request, response, codigoErrorHttpDefualt);

        JsonGenerator generator = null;
        try {
            generator = mapper.getJsonFactory().
                    createJsonGenerator(response.getOutputStream(), encoding);
            mapper.writeValue(generator, infoFiltrada);
        } catch(IOException ioe) {
            log.error("Error al escribir cadena en formato json.", ioe);
        }

        ServicioNotificacion notificador = resolverNotificador(ex.getClass());

        if(notificador != null) {
            notificador.notificarError(info);
        }
        // No interesa devolver un ModelAndView.
        return null;
    }

    /**
     * Busca la clase de excepción, registrada en el mapeo, más cercana en
     * cuanto a herencia, para así determinar el servicio de notificación para
     * la excepción.
     *
     * @see ServicioNotificacion
     * @param exLanzada
     * @return El servicio de n
     */
    protected ServicioNotificacion resolverNotificador(Class<?> exLanzada) {
        // Si se encuentra un match exacto.
        if(mapeoExcepciones.containsKey(exLanzada)) {
            return (ServicioNotificacion) mapeoExcepciones.get(exLanzada);
        }
        ServicioNotificacion notificador = null;
        int distanciaSuperClaseAnterior = 1000;
        int distanciaSuperClase = 1;

        for(Class<?> exMapeada: mapeoExcepciones.keySet()) {
            if(exMapeada.isAssignableFrom(exLanzada)) {
                distanciaSuperClase = calcularDistanciaSuperClase(exLanzada, exMapeada);
                if(distanciaSuperClase <= distanciaSuperClaseAnterior) {
                    distanciaSuperClaseAnterior = distanciaSuperClase;
                    notificador = (ServicioNotificacion) mapeoExcepciones.get(exMapeada);
                }
            }
        }

        return notificador;
    }

    /**
     * Busca la clase de excepción, registrada en el mapeo, más cercana en
     * cuanto a herencia, para así determinar la etiqueta de nivel del gravedad del error.
     *
     * @param exLanzada
     * @return
     */
    protected String resolverNivelError(Class<?> exLanzada) {
        if(mapeoNivelErrores.containsKey(exLanzada)) {
            return mapeoNivelErrores.get(exLanzada);
        }
        String nivel = NIVEL_DEFAULT;
        int distanciaSuperClaseAnterior = 1000;
        int distanciaSuperClase = 1;

        for(Class<?> exMapeada: mapeoNivelErrores.keySet()) {
            if(exMapeada.isAssignableFrom(exLanzada)) {
                distanciaSuperClase = calcularDistanciaSuperClase(exLanzada, exMapeada);
                if(distanciaSuperClase <= distanciaSuperClaseAnterior) {
                    distanciaSuperClaseAnterior = distanciaSuperClase;
                    nivel = mapeoNivelErrores.get(exMapeada);
                }
            }
        }

        return nivel;
    }

    /**
     * Calcula la distancia en la jerarquía de herencia entre la excepción lanzada y
     * una de las excepciones mapeadas en el bean.
     *
     * @param exLanzada
     * @param exMapeada
     * @return 0 si son del mismo tipo. -1 Si exLanzada y exMapeada no tienen relación de herencia.
     */
    protected int calcularDistanciaSuperClase(Class<?> exLanzada, Class<?> exMapeada) {
        return calcularDistanciaSuperClase(exLanzada, exMapeada, 0);
    }

    /**
     * Calcula la distancia en la jerarquía de herencia entre la excepción lanzada y
     * una de las excepciones mapeadas en el bean. El método usa recursividad.
     *
     * @param exLanzada
     * @param exMapeada
     * @param distancia
     * @return
     */
    private int calcularDistanciaSuperClase(Class<?> exLanzada, Class<?> exMapeada, int distancia) {
        if(exLanzada.equals(exMapeada)) {
            return distancia;
        }

        if(exLanzada.equals(Throwable.class)) {
            return -1;
        }

        return calcularDistanciaSuperClase(exLanzada.getSuperclass(), exMapeada, distancia + 1);
    }

    /**
     * Prepara el objeto response para devolver un error en formato JSON.
     * Usa además el método prepareResponse de la super clase {@link AbstractHandlerExceptionResolver}
     * para configurar aspectos del cache. Por ejemplo, se desactiva el caché.
     *
     * @see AbstractHandlerExceptionResolver
     * @param ex
     * @param response
     */
    @Override
    protected void prepareResponse(Exception ex, HttpServletResponse response) {
        if(log.isDebugEnabled()) {
            log.debug("Preparando objeto reponse para información de error.");
        }
        response.setContentType(CONTENT_TYPE);
        response.setCharacterEncoding(encoding.getJavaName());
        super.prepareResponse(ex, response);
    }

    /**
     * Prepara un objeto con toda la información del error que se ha generado.
     *
     * @see InformacionError
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @return Una instancia de {@link InformacionError}
     */
    protected InformacionError prepararInformacionError(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        InformacionError info = new InformacionError();
        info.setMensaje(ex.getMessage());
        info.setStatusText(ex.getMessage());
        info.setExcepcion(ex);
        Date momentoError = new Date();
        info.setMomentoError(momentoError);
        Long claveError = momentoError.getTime();
        info.setClaveError(claveError.toString());
        UsuarioSeguridad usuario = SeguridadUtil.getUsuarioActual();
        info.setUsuario(usuario);
        info.setClaseExcepcion(ex.getClass());
        info.setStatus(codigoErrorHttpDefualt);

        String mensaje = messageSource.getMessage("general.mensajeError.default", new Object[]{},
                                                  "Ocurrió un error inesperado. Consulte con el administrador usando la clave del error.", LocaleUtil.getLocale());
        esProfileDesarrollo = ctx.getEnvironment().acceptsProfiles(this.nombreProfileDesarrollo);

        if(MessageSourceResolvable.class.isAssignableFrom(ex.getClass()) && !((BaseTipoError) ex).isMensajeResuelto()) {

            if(BaseTipoError.class.isAssignableFrom(ex.getClass())) {
                BaseTipoError eb = (BaseTipoError) ex;
                try {
                    mensaje = messageSource.getMessage(eb, LocaleUtil.getLocale());
//                    mensaje = messageSource.getMessage(eb.getCodes()[0], eb.getArguments(), SeguridadUtil.getLocale());
                } catch(Exception e) {
                    logger.error("Error al resolver el mensaje i18n para la excepción (se usará mensaje genérico): " + ex.
                            getMessage(), e);
                }
            }
            info.setMensaje(mensaje);
            info.setStatusText(mensaje);
        } else if(!MessageSourceResolvable.class.isAssignableFrom(ex.getClass()) && !esProfileDesarrollo) {
            info.setMensaje(mensaje);
            info.setStatusText(mensaje);
        }

        info.setUrlPeticion(request.getRequestURL().
                toString());
        info.setHost(request.getRemoteAddr());
        info.setClaseHandler(handler.getClass());

        if(BaseTipoError.class.isAssignableFrom(ex.getClass())) {
            info.setExtraInfo(((BaseTipoError) ex).getExtraInfo());
        }

        return info;
    }

    /**
     * Prepara información del error dentro de un {@link BeanMap}.
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @return Un objeto de tipo BeanMap con toda la información del error.
     */
    protected Map prepararMapaInformacion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        return new BeanMap(prepararInformacionError(request, response, handler, ex));
    }

    /**
     * Convierte un objeto de tipo {@link InformacionError} en un {@link BeanMap}.
     *
     * @param info
     * @return Un objeto de tipo BeanMap con toda la información del error.
     */
    protected Map prepararMapaInformacion(InformacionError info) {
        return new BeanMap(info);
    }

    /**
     * Devuelve un Map con la información del error quitando las entradas de
     * las llaves mencionadas en el arreglo filtradas.
     *
     * Esto ayuda a reducir la información enviada al cliente. Los campos que se
     * pueden filtrar al momento son los de la clase {@link InformacionError}.
     *
     * @param informacion Mapa con la información del error.
     * @return Un objeto de tipo BeanMap con toda la información del error.
     */
    protected Map filtrarInfoError(Map informacion) {
        Map result = new HashMap(informacion);

        for(String filtro: filtrados) {
            result.remove(filtro);
        }
        return result;
    }

    /**
     * A todos los errores devueltos se les coloca 503, esto es configurable con
     * el campo códigoErrorHttpDefualt.
     *
     * @param request
     * @param response
     * @param statusCode
     */
    protected void aplicarCódigoErrorHttp(HttpServletRequest request, HttpServletResponse response, int statusCode) {
        if(!WebUtils.isIncludeRequest(request)) {
            if(log.isDebugEnabled()) {
                log.debug("Aplicando código de error HTTP " + statusCode);
            }
            response.setStatus(statusCode);
            request.setAttribute(WebUtils.ERROR_STATUS_CODE_ATTRIBUTE, statusCode);
        }
    }

    @PostConstruct
    protected void init() {
        for(Class<?> exMapeada: mapeoExcepciones.keySet()) {
            Object notificador = mapeoExcepciones.get(exMapeada);
            if(notificador != null) {
                if(notificador instanceof String && this.servicioNotificacionDefault != null) {
                    mapeoExcepciones.put(exMapeada, servicioNotificacionDefault);
                } else if(notificador instanceof String && this.servicioNotificacionDefault == null) {
                    mapeoExcepciones.put(exMapeada, null);
                }
            }
        }
    }

    /**
     * @param ServicioNotificacionDefault the ServicioNotificacionDefault to set
     */
    public void setServicioNotificacionDefault(ServicioNotificacion ServicioNotificacionDefault) {
        this.servicioNotificacionDefault = ServicioNotificacionDefault;
    }

    /**
     * @param mapeoExcepciones the mapeoExcepciones to set
     */
    public void setMapeoExcepciones(Map<Class<?>, Object> mapeoExcepciones) {
        this.mapeoExcepciones = mapeoExcepciones;
    }

    /**
     * @param filtrados the filtrados to set
     */
    public void setFiltrados(String[] filtrados) {
        this.filtrados = filtrados;
    }

    /**
     * @param códigoErrorHttpDefualt the códigoErrorHttpDefualt to set
     */
    public void setCódigoErrorHttpDefualt(Integer códigoErrorHttpDefualt) {
        this.codigoErrorHttpDefualt = códigoErrorHttpDefualt;
    }

    /**
     * @param mapeoNivelErrores the mapeoNivelErrores to set
     */
    public void setMapeoNivelErrores(Map<Class<?>, String> mapeoNivelErrores) {
        this.mapeoNivelErrores = mapeoNivelErrores;
    }

    /**
     * @param ambiente
     */
    public void setNombreProfileDesarrollo(String nombre) {
        this.nombreProfileDesarrollo = nombre;        
    }

	public void setApplicationContext(ApplicationContext ctx)
			throws BeansException {
		this.ctx = ctx;		
	}
}

