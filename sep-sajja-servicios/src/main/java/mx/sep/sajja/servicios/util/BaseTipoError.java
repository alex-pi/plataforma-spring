package mx.sep.sajja.servicios.util;

import org.springframework.context.MessageSourceResolvable;

/**
 *
 * @author Alejandro Pimentel
 *  
 */
public abstract class BaseTipoError
        extends RuntimeException
        implements MessageSourceResolvable {

	private static final long serialVersionUID = 7217445484129502645L;

	private String[] codes;

    private Object[] arguments;

    private String defaultMessage;

    private boolean resolvable;

    private boolean mensajeResuelto;

    private Object extraInfo;

    public BaseTipoError() {
        super();
    }

    private void setComunes(String codigoMensaje, Object[] argumentosMensaje) {
        this.codes = new String[1];
        this.codes[0] = codigoMensaje;
        this.arguments = argumentosMensaje;
        this.resolvable = true;
    }

    public BaseTipoError(String message) {
        super(message);
    }

    public BaseTipoError(String msg, Throwable t) {
        super(msg, t);
    }

    public BaseTipoError(String message, Object extraInfo) {
        super(message);
        this.extraInfo = extraInfo;
    }

    public BaseTipoError(String msg, Throwable t, Object extraInfo) {
        super(msg, t);
        this.extraInfo = extraInfo;
    }

    public BaseTipoError(Throwable t, String codigoMensaje, Object[] argumentosMensaje) {
        super(t);
        this.setComunes(codigoMensaje, argumentosMensaje);
    }

    public BaseTipoError(Throwable t, String codigoMensaje, String mensajeDefault, Object[] argumentosMensaje) {
        super(mensajeDefault, t);
        this.defaultMessage = mensajeDefault;
        this.setComunes(codigoMensaje, argumentosMensaje);
    }

    public BaseTipoError(String codigoMensaje, Object[] argumentosMensaje) {
        super();
        this.setComunes(codigoMensaje, argumentosMensaje);
    }

    public BaseTipoError(String codigoMensaje, String mensajeDefault, Object[] argumentosMensaje) {
        super(mensajeDefault);
        this.defaultMessage = mensajeDefault;
        this.setComunes(codigoMensaje, argumentosMensaje);
    }

    public BaseTipoError(Throwable t, String codigoMensaje, Object[] argumentosMensaje, Object extraInfo) {
        this(t, codigoMensaje, argumentosMensaje);
        this.extraInfo = extraInfo;
    }

    public BaseTipoError(Throwable t, String codigoMensaje, String mensajeDefault, Object[] argumentosMensaje, Object extraInfo) {
        this(t, codigoMensaje, mensajeDefault, argumentosMensaje);
        this.extraInfo = extraInfo;
    }

    public BaseTipoError(String codigoMensaje, Object[] argumentosMensaje, Object extraInfo) {
        this(codigoMensaje, argumentosMensaje);
        this.extraInfo = extraInfo;
    }

    public BaseTipoError(String codigoMensaje, String mensajeDefault, Object[] argumentosMensaje, Object extraInfo) {
        this(codigoMensaje, mensajeDefault, argumentosMensaje);
        this.extraInfo = extraInfo;
    }

    public String[] getCodes() {
        return this.codes;
    }

    public Object[] getArguments() {
        return this.arguments;
    }

    public String getDefaultMessage() {
        return this.getMessage();
    }

    public Object getExtraInfo() {
        return this.extraInfo;
    }

    public boolean isResolvable() {
        return this.resolvable;
    }

    /**
     * Indica que el mensaje fue resuelto por i18n.
     *
     * @return mensajeResuelto
     */
    public boolean isMensajeResuelto() {
        return mensajeResuelto;
    }

    /**
     * @param mensajeResuelto the mensajeResuelto to set
     */
    public void setMensajeResuelto(boolean mensajeResuelto) {
        this.mensajeResuelto = mensajeResuelto;
    }
}

