package mx.sep.sajja.servicios.util;

/**
 * Created with IntelliJ IDEA.
 * User: pi
 * Date: 11/27/12
 * Time: 4:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class ExcepcionProcesoParcial extends ErrorNegocio{

    public ExcepcionProcesoParcial(){
        super();
    }

    public ExcepcionProcesoParcial(String message){
        super(message);
    }

    public ExcepcionProcesoParcial(String msg, Throwable t){
        super(msg,t);
    }

    public ExcepcionProcesoParcial(String message, Object extraInfo){
        super(message, extraInfo);
    }

    public ExcepcionProcesoParcial(String msg, Throwable t, Object extraInfo){
        super(msg,t,extraInfo);
    }

    public ExcepcionProcesoParcial(Throwable t, String codigoMensaje, Object[] argumentosMensaje) {
        super(t, codigoMensaje, argumentosMensaje);
    }

    public ExcepcionProcesoParcial(Throwable t, String codigoMensaje, String mensajeDefault, Object[] argumentosMensaje) {
        super(t, codigoMensaje, mensajeDefault, argumentosMensaje);
    }

    public ExcepcionProcesoParcial(Object[] argumentosMensaje, String codigoMensaje) {
        super(codigoMensaje, argumentosMensaje);
    }

    public ExcepcionProcesoParcial(String codigoMensaje, String mensajeDefault, Object[] argumentosMensaje) {
        super(codigoMensaje, mensajeDefault, argumentosMensaje);
    }

    public ExcepcionProcesoParcial(Throwable t, String codigoMensaje, Object[] argumentosMensaje, Object extraInfo) {
        super(t, codigoMensaje, argumentosMensaje, extraInfo);
    }

    public ExcepcionProcesoParcial(Throwable t, String codigoMensaje, String mensajeDefault, Object[] argumentosMensaje, Object extraInfo) {
        super(t, codigoMensaje, mensajeDefault, argumentosMensaje, extraInfo);
    }

    public ExcepcionProcesoParcial(Object[] argumentosMensaje, String codigoMensaje, Object extraInfo) {
        super(argumentosMensaje, codigoMensaje, extraInfo);
    }

    public ExcepcionProcesoParcial(String codigoMensaje, String mensajeDefault, Object[] argumentosMensaje, Object extraInfo) {
        super(codigoMensaje, mensajeDefault, argumentosMensaje, extraInfo);
    }
}
