package mx.sep.sajja.servicios.util;

import org.springframework.context.MessageSource;

/**
 * 
 * Excepción lanzada por algún componente de infraestructura. En algunos
 * casos este tipo de errores representan bugs que deberían ser corregidos.
 * También pueden ser errores que componentes aplicativos usan en su 
 * funcionalidad propia.
 * 
 * Un caso típico de esto último es {@link AccessDeniedException} que es lanzada
 * cada vez que a un Principal se le niega cierto permiso.
 * 
 * Dado lo anterior este tipo de errores no deberían ser lanzadas desde código de
 * negocio.
 * 
 * @author Alejandro Pimentel
 *
 */
public class ErrorInfraestructura extends BaseTipoError {
		 
	private static final long serialVersionUID = -4917062960842845345L;

	public ErrorInfraestructura(){
        super();
    }

	/**
	 * 
	 * @param message Mensaje literal que brinda mayor información sobre el error.
	 */
    public ErrorInfraestructura(String message){
        super(message);
    }

    /**
     * Constructor que permite envolver una excepción arbitraria.
     * 
     * @param msg Mensaje literal que brinda mayor información sobre el error.
     * @param t La excepción originalmente lanzada. Cuando esta existe es buena práctica conservarla y envolverla detro de otro
     * 			tipo de excepción que tenga mayor significado dentro de la aplicación.
     */
    public ErrorInfraestructura(String msg, Throwable t){
        super(msg,t);
    }

    /**
     * 
     * @param message Mensaje literal que brinda mayor información sobre el error.
     * @param extraInfo Algún bean que contenga información que la aplicación deba procesar debido al error. Por ejemplo
     * 			{@link ManejadorErroresJson} puede convertirlo a formato json para pasarlo como respuesta al cliente.
     */
    public ErrorInfraestructura(String message, Object extraInfo){
        super(message, extraInfo);
    }

    /**
     * 
     * @param msg Mensaje literal que brinda mayor información sobre el error.
     * @param t La excepción originalmente lanzada. Cuando esta existe es buena práctica conservarla y envolverla detro de otro
     * 			tipo de excepción que tenga mayor significado dentro de la aplicación.
     * @param extraInfo Algún bean que contenga información que la aplicación deba procesar debido al error. Por ejemplo
     * 			{@link ManejadorErroresJson} puede convertirlo a formato json para pasarlo como respuesta al cliente.
     */
    public ErrorInfraestructura(String msg, Throwable t, Object extraInfo){
        super(msg,t,extraInfo);
    }

    /**
     * 
     * @param t La excepción originalmente lanzada. Cuando esta existe es buena práctica conservarla y envolverla detro de otro
     * 			tipo de excepción que tenga mayor significado dentro de la aplicación.
     * @param codigoMensaje Código de un mensaje para ser resuelto vía alguna implementación de {@link MessageSource}.
     * @param argumentosMensaje Los valores que serán sustituidos en los "placeholders" dentro del mensaje. Estos placeholders
     * 						son de la forma {n}. Los valores serán tomados según el orden dentro del arreglo.
     */
    public ErrorInfraestructura(Throwable t, String codigoMensaje, Object[] argumentosMensaje) {
        super(t, codigoMensaje, argumentosMensaje);
    }

    /**
     * 
     * @param t La excepción originalmente lanzada. Cuando esta existe es buena práctica conservarla y envolverla detro de otro
     * 			tipo de excepción que tenga mayor significado dentro de la aplicación.
     * @param codigoMensaje Código de un mensaje para ser resuelto vía alguna implementación de {@link MessageSource}.
     * @param mensajeDefault Si el código del mensaje no puede resuelto se usará el mensaje literal default.
     * @param argumentosMensaje Los valores que serán sustituidos en los "placeholders" dentro del mensaje. Estos placeholders
     * 						son de la forma {n}. Los valores serán tomados según el orden dentro del arreglo.
     */
    public ErrorInfraestructura(Throwable t, String codigoMensaje, String mensajeDefault, Object[] argumentosMensaje) {
        super(t, codigoMensaje, mensajeDefault, argumentosMensaje);
    }

    /**
     * 
     * @param argumentosMensaje Los valores que serán sustituidos en los "placeholders" dentro del mensaje. Estos placeholders
     * 						son de la forma {n}. Los valores serán tomados según el orden dentro del arreglo.
     * @param codigoMensaje Código de un mensaje para ser resuelto vía alguna implementación de {@link MessageSource}.
     */
    public ErrorInfraestructura(Object[] argumentosMensaje, String codigoMensaje) {
        super(codigoMensaje, argumentosMensaje);
    }

    /**
     * 
     * @param codigoMensaje Código de un mensaje para ser resuelto vía alguna implementación de {@link MessageSource}.
     * @param mensajeDefault Si el código del mensaje no puede resuelto se usará el mensaje literal default.
     * @param argumentosMensaje Los valores que serán sustituidos en los "placeholders" dentro del mensaje. Estos placeholders
     * 						son de la forma {n}. Los valores serán tomados según el orden dentro del arreglo.
     */
    public ErrorInfraestructura(String codigoMensaje, String mensajeDefault, Object[] argumentosMensaje) {
        super(codigoMensaje, mensajeDefault, argumentosMensaje);
    }

    /**
     * 
     * @param t La excepción originalmente lanzada. Cuando esta existe es buena práctica conservarla y envolverla detro de otro
     * 			tipo de excepción que tenga mayor significado dentro de la aplicación.
     * @param codigoMensaje Código de un mensaje para ser resuelto vía alguna implementación de {@link MessageSource}.
     * @param argumentosMensaje Los valores que serán sustituidos en los "placeholders" dentro del mensaje. Estos placeholders
     * 						son de la forma {n}. Los valores serán tomados según el orden dentro del arreglo.
     * @param extraInfo Algún bean que contenga información que la aplicación deba procesar debido al error. Por ejemplo
     * 			{@link ManejadorErroresJson} puede convertirlo a formato json para pasarlo como respuesta al cliente.
     */
    public ErrorInfraestructura(Throwable t, String codigoMensaje, Object[] argumentosMensaje, Object extraInfo) {
        super(t, codigoMensaje, argumentosMensaje, extraInfo);
    }

    /**
     * 
     * @param t La excepción originalmente lanzada. Cuando esta existe es buena práctica conservarla y envolverla detro de otro
     * 			tipo de excepción que tenga mayor significado dentro de la aplicación.
     * @param codigoMensaje Código de un mensaje para ser resuelto vía alguna implementación de {@link MessageSource}.
     * @param mensajeDefault Si el código del mensaje no puede resuelto se usará el mensaje literal default.
     * @param argumentosMensaje Los valores que serán sustituidos en los "placeholders" dentro del mensaje. Estos placeholders
     * 						son de la forma {n}. Los valores serán tomados según el orden dentro del arreglo.
     * @param extraInfo Algún bean que contenga información que la aplicación deba procesar debido al error. Por ejemplo
     * 			{@link ManejadorErroresJson} puede convertirlo a formato json para pasarlo como respuesta al cliente.
     */
    public ErrorInfraestructura(Throwable t, String codigoMensaje, String mensajeDefault, Object[] argumentosMensaje, Object extraInfo) {
        super(t, codigoMensaje, mensajeDefault, argumentosMensaje, extraInfo);
    }

    /**
     * 
     * @param argumentosMensaje Los valores que serán sustituidos en los "placeholders" dentro del mensaje. Estos placeholders
     * 						son de la forma {n}. Los valores serán tomados según el orden dentro del arreglo.
     * @param codigoMensaje Código de un mensaje para ser resuelto vía alguna implementación de {@link MessageSource}.
     * @param extraInfo Algún bean que contenga información que la aplicación deba procesar debido al error. Por ejemplo
     * 			{@link ManejadorErroresJson} puede convertirlo a formato json para pasarlo como respuesta al cliente.
     */
    public ErrorInfraestructura(Object[] argumentosMensaje, String codigoMensaje, Object extraInfo) {
        super(codigoMensaje, argumentosMensaje, extraInfo);
    }

    /**
     * 
     * @param codigoMensaje Código de un mensaje para ser resuelto vía alguna implementación de {@link MessageSource}.
     * @param mensajeDefault Si el código del mensaje no puede resuelto se usará el mensaje literal default.
     * @param argumentosMensaje Los valores que serán sustituidos en los "placeholders" dentro del mensaje. Estos placeholders
     * 						son de la forma {n}. Los valores serán tomados según el orden dentro del arreglo.
     * @param extraInfo Algún bean que contenga información que la aplicación deba procesar debido al error. Por ejemplo
     * 			{@link ManejadorErroresJson} puede convertirlo a formato json para pasarlo como respuesta al cliente.
     */
    public ErrorInfraestructura(String codigoMensaje, String mensajeDefault, Object[] argumentosMensaje, Object extraInfo) {
        super(codigoMensaje, mensajeDefault, argumentosMensaje, extraInfo);
    }
}
