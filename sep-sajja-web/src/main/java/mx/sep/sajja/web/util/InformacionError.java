package mx.sep.sajja.web.util;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

import mx.sep.seguridad.modelo.UsuarioSeguridad;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

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
     * @return the claseExcepción
     */
    public Class<?> getClaseExcepcion() {
        return claseExcepcion;
    }

    /**
     * @param claseExcepción the claseExcepción to set
     */
    public void setClaseExcepcion(Class<?> claseExcepcion) {
        this.claseExcepcion = claseExcepcion;
    }

    /**
     * @return the excepción
     */
    public Throwable getExcepcion() {
        return excepcion;
    }

    /**
     * @param excepción the excepción to set
     */
    public void setExcepcion(Throwable excepcion) {
        this.excepcion = excepcion;
    }

    /**
     * @return the momentoError
     */
    public Date getMomentoError() {
        return momentoError;
    }

    /**
     * @param momentoError the momentoError to set
     */
    public void setMomentoError(Date momentoError) {
        this.momentoError = momentoError;

        DateFormat complDf = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);

        momentoErrorFrmt = complDf.format(getMomentoError());
    }

    /**
     * @return the usuario
     */
    public UsuarioSeguridad getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(UsuarioSeguridad usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * @return the claseHandler
     */
    public Class<?> getClaseHandler() {
        return claseHandler;
    }

    /**
     * @param claseHandler the claseHandler to set
     */
    public void setClaseHandler(Class<?> claseHandler) {
        this.claseHandler = claseHandler;
    }

    /**
     * @return the host
     */
    public String getHost() {
        return host;
    }

    /**
     * @param host the host to set
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * @return the urlPetición
     */
    public String getUrlPeticion() {
        return urlPeticion;
    }

    /**
     * @param urlPetición the urlPetición to set
     */
    public void setUrlPeticion(String urlPeticion) {
        this.urlPeticion = urlPeticion;
    }

    /**
     * @return the nivelError
     */
    public String getNivelError() {
        return nivelError;
    }

    /**
     * @param nivelError the nivelError to set
     */
    public void setNivelError(String nivelError) {
        this.nivelError = nivelError;
    }

    /**
     * @return the momentoErrorFrmt
     */
    public String getMomentoErrorFrmt() {
        return momentoErrorFrmt;
    }

    /**
     * @return the extraInfo
     */
    public Object getExtraInfo() {
        return extraInfo;
    }

    /**
     * @param extraInfo the extraInfo to set
     */
    public void setExtraInfo(Object extraInfo) {
        this.extraInfo = extraInfo;
    }

    /**
     * @return
     */
    public String getClaveError() {
        return claveError;
    }

    /**
     * @param claveError
     */
    public void setClaveError(String claveError) {
        this.claveError = claveError;
    }

    /**
     * @return the status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return the statusText
     */
    public String getStatusText() {
        return statusText;
    }

    /**
     * @param statusText the statusText to set
     */
    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }
}
