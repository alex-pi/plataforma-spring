package mx.sep.sajja.servicios.util;

import org.springframework.context.MessageSource;

/**
 * 
 * Excepción lanzada cuando se detecta un error en la lógica de negocio
 * por la cual el proceso de negocio debe ser interrumpido.
 * 
 * @author Alejandro Pimentel
 *
 */
public class ErrorNegocio extends BaseTipoError {
		 
	private static final long serialVersionUID = -1128852941580331211L;

	/**
	 * Constructor defaul. No se recomienda su uso ya que se debe
	 * intentar proveer más información por medio de un mensaje.
	 * 
	 */
	public ErrorNegocio(){
        super();
    }

	/**
	 * 
	 * @param message Mensaje literal que brinda mayor información sobre el error.
	 */
    public ErrorNegocio(String message){
        super(message);
    }

    /**
     * Constructor que permite envolver una excepción arbitraria.
     * 
     * @param msg Mensaje literal que brinda mayor información sobre el error.
     * @param t La excepción originalmente lanzada. Cuando esta existe es buena práctica conservarla y envolverla detro de otro
     * 			tipo de excepción que tenga mayor significado dentro de la aplicación.
     */
    public ErrorNegocio(String msg, Throwable t){
        super(msg,t);
    }

    /**
     * 
     * @param message Mensaje literal que brinda mayor información sobre el error.
     * @param extraInfo Algún bean que contenga información que la aplicación deba procesar debido al error. Por ejemplo
     * 			{@link ManejadorErroresJson} puede convertirlo a formato json para pasarlo como respuesta al cliente.
     */
    public ErrorNegocio(String message, Object extraInfo){
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
    public ErrorNegocio(String msg, Throwable t, Object extraInfo){
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
    public ErrorNegocio(Throwable t, String codigoMensaje, Object[] argumentosMensaje) {
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
    public ErrorNegocio(Throwable t, String codigoMensaje, String mensajeDefault, Object[] argumentosMensaje) {
        super(t, codigoMensaje, mensajeDefault, argumentosMensaje);
    }

    /**
     * 
     * @param argumentosMensaje Los valores que serán sustituidos en los "placeholders" dentro del mensaje. Estos placeholders
     * 						son de la forma {n}. Los valores serán tomados según el orden dentro del arreglo.
     * @param codigoMensaje Código de un mensaje para ser resuelto vía alguna implementación de {@link MessageSource}.
     */
    public ErrorNegocio(Object[] argumentosMensaje, String codigoMensaje) {
        super(codigoMensaje, argumentosMensaje);
    }

    /**
     * 
     * @param codigoMensaje Código de un mensaje para ser resuelto vía alguna implementación de {@link MessageSource}.
     * @param mensajeDefault Si el código del mensaje no puede resuelto se usará el mensaje literal default.
     * @param argumentosMensaje Los valores que serán sustituidos en los "placeholders" dentro del mensaje. Estos placeholders
     * 						son de la forma {n}. Los valores serán tomados según el orden dentro del arreglo.
     */
    public ErrorNegocio(String codigoMensaje, String mensajeDefault, Object[] argumentosMensaje) {
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
    public ErrorNegocio(Throwable t, String codigoMensaje, Object[] argumentosMensaje, Object extraInfo) {
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
    public ErrorNegocio(Throwable t, String codigoMensaje, String mensajeDefault, Object[] argumentosMensaje, Object extraInfo) {
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
    public ErrorNegocio(Object[] argumentosMensaje, String codigoMensaje, Object extraInfo) {
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
    public ErrorNegocio(String codigoMensaje, String mensajeDefault, Object[] argumentosMensaje, Object extraInfo) {
        super(codigoMensaje, mensajeDefault, argumentosMensaje, extraInfo);
    }
}
