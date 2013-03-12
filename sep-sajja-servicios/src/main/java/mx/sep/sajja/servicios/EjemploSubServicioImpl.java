package mx.sep.sajja.servicios;

import mx.sep.sajja.dao.EscuelaDao;
import mx.sep.sajja.dao.UsuarioDao;
import mx.sep.sajja.modelo.Ejemplo;
import mx.sep.sajja.modelo.Escuela;
import mx.sep.sajja.modelo.Usuario;
import mx.sep.sajja.servicios.util.ErrorNegocio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Las clases de servicio deben llevar el estereotipo {@link org.springframework.stereotype.Service} para
 * spring los tome como beans dentro del contenedor.
 *
 * @author Alejandro Pimentel
 *
 */
@Service
public class EjemploSubServicioImpl implements EjemploSubServicio {

	private static final Logger log = LoggerFactory.getLogger(EjemploSubServicioImpl.class);

    @Autowired
    private EscuelaDao escuelaDao;
    @Autowired
    private UsuarioDao usuarioDao;

    public void transaccionAtomica(String nombreEscuela){
        escuelaDao.modificarPorNombre(new Escuela(nombreEscuela, 50));

        //throw new ErrorNegocio("Se lanza excepción para provocar un rollback en la transacción.");
    }
}
