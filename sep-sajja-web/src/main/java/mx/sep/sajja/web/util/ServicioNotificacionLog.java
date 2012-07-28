package mx.sep.sajja.web.util;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 *
 ** @author Alejandro Pimentel 
 */
public class ServicioNotificacionLog implements ServicioNotificacion{
    Logger log = LoggerFactory.getLogger(ServicioNotificacionLog.class);
    static final String bline = System.getProperty ("line.separator");

    public void notificarError(InformacionError infoError) {
        StringBuilder buff = new StringBuilder();
        buff.append(bline);
        buff.append("******** INICIO INFO ERROR ********");
        buff.append(bline);
        buff.append("Clase Excepción: ");
        buff.append(infoError.getClaseExcepcion().getCanonicalName());
        buff.append(bline);
        buff.append("Clave de error: ");
        buff.append(infoError.getClaveError());
        buff.append(bline);
        buff.append("Lanzada Por: ");
        buff.append(infoError.getClaseHandler().getCanonicalName());
        buff.append(bline);
        buff.append("Mensaje: ");
        buff.append(infoError.getMensaje());
        buff.append(bline);
        buff.append("Prioridad error: ");
        buff.append(infoError.getNivelError());
        buff.append(bline);
        buff.append("URL de petición: ");
        buff.append(infoError.getUrlPeticion());
        buff.append(bline);
        buff.append("Host remoto: ");
        buff.append(infoError.getHost());
        buff.append(bline);
        buff.append("Hora: ");
        buff.append(infoError.getMomentoError());
        buff.append(bline);
        buff.append("Usuario: ");
        buff.append(infoError.getUsuario().getUsername());
        buff.append(bline);
        buff.append("******** FIN INFO ERROR ********");
        
        log.error(buff.toString());
        log.error(infoError.getMensaje(), infoError.getExcepcion());        
    }

}
