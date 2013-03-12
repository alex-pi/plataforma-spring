package mx.sep.sajja.servicios;

import mx.sep.sajja.dao.EscuelaDao;
import mx.sep.sajja.dao.UsuarioDao;
import mx.sep.sajja.modelo.Ejemplo;
import mx.sep.sajja.modelo.Escuela;
import mx.sep.sajja.modelo.Usuario;
import mx.sep.sajja.servicios.util.ErrorNegocio;

import mx.sep.sajja.servicios.util.ExcepcionProcesoParcial;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Las clases de servicio deben llevar el estereotipo {@link Service} para
 * spring los tome como beans dentro del contenedor.
 * 
 * @author Alejandro Pimentel
 *
 */
@Service
public class EjemploServicioImpl implements EjemploServicio {

	private static final Logger log = LoggerFactory.getLogger(EjemploServicioImpl.class);

    @Autowired
    private EscuelaDao escuelaDao;
    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private EjemploSubServicio ejemploSubServicio;
	
	/**
	 * Cuando se en encuentra un error o inconsistencia en el negocio se puede lanzar
	 * una excepción detallando en un mensaje lo sucedido.
	 * 
	 * El lanzar esta excepción también implica que a la transacción iniciada al llamar a
	 * este método de servicio se le hará rollback. De este modo no se afectará nada dentro de
	 * la BD.
	 * 
	 */
	public void ejemploMensajeErrorNegocio(){
		throw new ErrorNegocio("Aqui se explica lo que salió mal con la lógica de negocio.");
	}
	
	/**
	 * Estos mensajes pueden ser un código de un mensaje que se encuentre declarado dentro
	 * de un archivo properties dentro del directorio WEB-INF/mensajes.
	 * 
	 * Pueden también llevar un objeto con información adicional. En nuestro caso, este mensaje
	 * será devuelto en formato json al cliente.
	 * 
	 */
	public void ejemploCodigoMensajeErrorNegocio(){
		Ejemplo e = new Ejemplo();
		e.setId(1l);
		e.setCampo1("Información adicional del error.");
		throw new ErrorNegocio(new Object[]{}, "codigo.mensaje.ejemplo", e);
	}	

    public void transaccionAtomica(Escuela escuela, Usuario usuario, String nombreEscuela){
        escuelaDao.guardar(escuela);
        usuarioDao.guardar(usuario);

        ejemploSubServicio.transaccionAtomica("Escuela Secundaria No. 99");

        throw new ErrorNegocio("Se lanza excepción para provocar un rollback en la transacción.");
    }

    public void transaccionRegistroParcial(Escuela escuela, String nombreEscuela){
        Integer mods = escuelaDao.guardar(escuela);

        if(true)
            throw new ExcepcionProcesoParcial("Según está configurada, esta excepción no provoca un rollback" +
                    ", provocando así un registro parcial de lo realizado por la capa de servicios.");

        ejemploSubServicio.transaccionAtomica("Escuela Secundaria No. 99");
    }
}
