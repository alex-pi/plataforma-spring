package mx.sep.sajja.servicios.util;

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

	public ErrorNegocio(){
        super();
    }

    public ErrorNegocio(String message){
        super(message);
    }

    public ErrorNegocio(String msg, Throwable t){
        super(msg,t);
    }

    public ErrorNegocio(String message, Object extraInfo){
        super(message, extraInfo);
    }

    public ErrorNegocio(String msg, Throwable t, Object extraInfo){
        super(msg,t,extraInfo);
    }

    public ErrorNegocio(Throwable t, String codigoMensaje, Object[] argumentosMensaje) {
        super(t, codigoMensaje, argumentosMensaje);
    }

    public ErrorNegocio(Throwable t, String codigoMensaje, String mensajeDefault, Object[] argumentosMensaje) {
        super(t, codigoMensaje, mensajeDefault, argumentosMensaje);
    }

    public ErrorNegocio(Object[] argumentosMensaje, String codigoMensaje) {
        super(codigoMensaje, argumentosMensaje);
    }

    public ErrorNegocio(String codigoMensaje, String mensajeDefault, Object[] argumentosMensaje) {
        super(codigoMensaje, mensajeDefault, argumentosMensaje);
    }

    public ErrorNegocio(Throwable t, String codigoMensaje, Object[] argumentosMensaje, Object extraInfo) {
        super(t, codigoMensaje, argumentosMensaje, extraInfo);
    }

    public ErrorNegocio(Throwable t, String codigoMensaje, String mensajeDefault, Object[] argumentosMensaje, Object extraInfo) {
        super(t, codigoMensaje, mensajeDefault, argumentosMensaje, extraInfo);
    }

    public ErrorNegocio(Object[] argumentosMensaje, String codigoMensaje, Object extraInfo) {
        super(codigoMensaje, argumentosMensaje, extraInfo);
    }

    public ErrorNegocio(String codigoMensaje, String mensajeDefault, Object[] argumentosMensaje, Object extraInfo) {
        super(codigoMensaje, mensajeDefault, argumentosMensaje, extraInfo);
    }
}
