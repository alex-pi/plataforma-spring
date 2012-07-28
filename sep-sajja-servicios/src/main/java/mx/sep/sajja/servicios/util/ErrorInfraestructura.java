package mx.sep.sajja.servicios.util;

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

    public ErrorInfraestructura(String message){
        super(message);
    }

    public ErrorInfraestructura(String msg, Throwable t){
        super(msg,t);
    }

    public ErrorInfraestructura(String message, Object extraInfo){
        super(message, extraInfo);
    }

    public ErrorInfraestructura(String msg, Throwable t, Object extraInfo){
        super(msg,t,extraInfo);
    }

    public ErrorInfraestructura(Throwable t, String codigoMensaje, Object[] argumentosMensaje) {
        super(t, codigoMensaje, argumentosMensaje);
    }

    public ErrorInfraestructura(Throwable t, String codigoMensaje, String mensajeDefault, Object[] argumentosMensaje) {
        super(t, codigoMensaje, mensajeDefault, argumentosMensaje);
    }

    public ErrorInfraestructura(Object[] argumentosMensaje, String codigoMensaje) {
        super(codigoMensaje, argumentosMensaje);
    }

    public ErrorInfraestructura(String codigoMensaje, String mensajeDefault, Object[] argumentosMensaje) {
        super(codigoMensaje, mensajeDefault, argumentosMensaje);
    }

    public ErrorInfraestructura(Throwable t, String codigoMensaje, Object[] argumentosMensaje, Object extraInfo) {
        super(t, codigoMensaje, argumentosMensaje, extraInfo);
    }

    public ErrorInfraestructura(Throwable t, String codigoMensaje, String mensajeDefault, Object[] argumentosMensaje, Object extraInfo) {
        super(t, codigoMensaje, mensajeDefault, argumentosMensaje, extraInfo);
    }

    public ErrorInfraestructura(Object[] argumentosMensaje, String codigoMensaje, Object extraInfo) {
        super(codigoMensaje, argumentosMensaje, extraInfo);
    }

    public ErrorInfraestructura(String codigoMensaje, String mensajeDefault, Object[] argumentosMensaje, Object extraInfo) {
        super(codigoMensaje, mensajeDefault, argumentosMensaje, extraInfo);
    }
}
