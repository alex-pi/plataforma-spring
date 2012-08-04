package mx.sep.sajja.web.util;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

import mx.sep.seguridad.modelo.UsuarioSeguridad;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Las instancias de esta clase contienen toda la información que sucedió dentro de la
 * aplicación. Es usada por alguna implementación de {@link ServicioNotificacion} para
 * publicar la información en algún medio (p.e. Logger o email).
 * 
 * @author Alejandro Pimentel
 *
 */
@JsonIgnoreProperties( { "excepcion" } )
public class InformacionError
        implements Serializable {

	private static final long serialVersionUID = 354478526898744851L;

	private Class<?> claseExcepcion;

    private Class<?> claseHandler;

    private transient Throwable excepcion;

    private Date momentoError;

    private String momentoErrorFrmt;

    private UsuarioSeguridad usuario;

    private String mensaje;

    private String host;

    private String urlPeticion;

    private String nivelError;

    private Object extraInfo;

    private String claveError;

    private Integer status;

    private String statusText;

    /**
     * @return La clase de la Excepción que fue lanzada.
     */
    public Class<?> getClaseExcepcion() {
        return claseExcepcion;
    }

    /**
     * @param La clase de la Excepción que fue lanzada.
     */
    public void setClaseExcepcion(Class<?> claseExcepcion) {
        this.claseExcepcion = claseExcepcion;
    }

    /**
     * @return El objeto de la Excepción o Error lanzados
     */
    public Throwable getExcepcion() {
        return excepcion;
    }

    /**
     * @param El objeto de la Excepción o Error lanzados
     */
    public void setExcepcion(Throwable excepcion) {
        this.excepcion = excepcion;
    }

    /**
     * @return El momento en que sucedió la excepción.
     */
    public Date getMomentoError() {
        return momentoError;
    }

    /**
     * @param momentoError El momento en que sucedió la excepción.
     */
    public void setMomentoError(Date momentoError) {
        this.momentoError = momentoError;

        DateFormat complDf = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);

        momentoErrorFrmt = complDf.format(getMomentoError());
    }

    /**
     * @return Información del usuario al momento que sucedió la excepción.
     */
    public UsuarioSeguridad getUsuario() {
        return usuario;
    }

    /**
     * @param usuario Información del usuario al momento que sucedió la excepción.
     */
    public void setUsuario(UsuarioSeguridad usuario) {
        this.usuario = usuario;
    }

    /**
     * @return El mensaje que detalla el error 
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje El mensaje que detalla el error 
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * @return El tipo de objeto del cual provino la excepción.
     */
    public Class<?> getClaseHandler() {
        return claseHandler;
    }

    /**
     * @param claseHandler El tipo de objeto del cual provino la excepción.
     */
    public void setClaseHandler(Class<?> claseHandler) {
        this.claseHandler = claseHandler;
    }

    /**
     * @return La dirección del cliente o del último proxy por el que la petición salió.
     */
    public String getHost() {
        return host;
    }

    /**
     * @param host La dirección del cliente o del último proxy por el que la petición salió.
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * @return El url reconstruido (completo) que el cliente solicitó.
     */
    public String getUrlPeticion() {
        return urlPeticion;
    }

    /**
     * @param urlPetición El url reconstruido (completo) que el cliente solicitó.
     */
    public void setUrlPeticion(String urlPeticion) {
        this.urlPeticion = urlPeticion;
    }

    /**
     * @return Una cadena que clasifica la gravedad del error sucedido.
     */
    public String getNivelError() {
        return nivelError;
    }

    /**
     * @param nivelError Una cadena que clasifica la gravedad del error sucedido.
     */
    public void setNivelError(String nivelError) {
        this.nivelError = nivelError;
    }

    /**
     * @return El momento del error con un formato más amigable.
     */
    public String getMomentoErrorFrmt() {
        return momentoErrorFrmt;
    }

    /**
     * @return Objeto arbitrario con información adicional del error. O información que deba ser procesada dado el error sucedido.
     */
    public Object getExtraInfo() {
        return extraInfo;
    }

    /**
     * @param extraInfo Objeto arbitrario con información adicional del error. O información que deba ser procesada dado el error sucedido.
     */
    public void setExtraInfo(Object extraInfo) {
        this.extraInfo = extraInfo;
    }

    /**
     * @return Una clave única del error. Puede ser usada para rastrear el error dentro de los archivos de log.
     */
    public String getClaveError() {
        return claveError;
    }

    /**
     * @param claveError Una clave única del error. Puede ser usada para rastrear el error dentro de los archivos de log.
     */
    public void setClaveError(String claveError) {
        this.claveError = claveError;
    }

    /**
     * @return Un código de error entregado al cliente. Si el cliente es HTTP se entregará un código de error 503. 
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status Un código de error entregado al cliente. Si el cliente es HTTP se entregará un código de error 503. 
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return Por default es el mensaje de la excepción original. Típicamente un detalle técnico.
     */
    public String getStatusText() {
        return statusText;
    }

    /**
     * @param statusText Por default es el mensaje de la excepción original. Típicamente un detalle técnico.
     */
    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }
}
