package test.mx.sep.sajja.servicios;

import mx.sep.sajja.dao.EscuelaDao;
import mx.sep.sajja.dao.UsuarioDao;
import mx.sep.sajja.modelo.Escuela;
import mx.sep.sajja.modelo.Usuario;
import mx.sep.sajja.servicios.EjemploServicio;
import mx.sep.sajja.servicios.util.ErrorNegocio;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)
public class EjemploServicioImplTest extends BaseServicioTest {
	
	@Autowired
	private EjemploServicio ejemploServicio;
    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private EscuelaDao escuelaDao;

    private Escuela escuela;
    private Usuario usuario;

    @Before
    public void before(){
        escuela = new Escuela("Patito", 20);
        usuario = new Usuario("Alejandro","Pimentel","apr@gmail.com","123","57895003");
    }

	@Test
	public void ejemploServicioDependenciaTest(){
		Assert.assertNotNull(ejemploServicio);
	}
	
	@Test(expected=ErrorNegocio.class)
	public void ejemploMensajeErrorNegocioTest(){
		ejemploServicio.ejemploCodigoMensajeErrorNegocio();
	}

    @Test
    public void transaccionAtomicaTest(){
        try {
            ejemploServicio.transaccionAtomica(escuela,usuario, "Escuela Secundaria No. 99");
            Assert.fail("Se debió lanzar excepción para hacer rollback.");
        } catch(ErrorNegocio ex){

            Assert.assertNotNull(escuela.getId());
            Assert.assertNotNull(usuario.getId());
            Integer idu = simpleJdbcTemplate.queryForObject
                    ("select id_t_usuario from t_usuario where v_correo = ?", Integer.class, "apr@gmail.com");
            Integer ide = simpleJdbcTemplate.queryForObject
                    ("select id_t_escuela from t_escuela where v_nombre = ?", Integer.class, "Patito");

            // No se ha dado rollback y se permite read-uncommited
            Assert.assertNotNull(idu);
            Assert.assertNotNull(ide);
        }
    }

}
