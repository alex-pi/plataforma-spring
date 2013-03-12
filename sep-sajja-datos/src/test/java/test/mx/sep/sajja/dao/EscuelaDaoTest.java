package test.mx.sep.sajja.dao;

import java.util.List;

import mx.sep.sajja.dao.EscuelaDao;
import mx.sep.sajja.modelo.Escuela;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EscuelaDaoTest extends BaseDaoTest {
	
	@Autowired
	private EscuelaDao escuelaDao;
    private Escuela escuela;

    @Before
    public void before(){
        escuela = new Escuela("Patito", 20);
    }
	
	@Test
	public void dependenciaTest(){
		Assert.assertNotNull(escuelaDao);
	}
	
	@Test
	public void consultarTodasTest(){
		List<Escuela> escuelas = escuelaDao.consultarTodos();
		Assert.assertEquals(2, escuelas.size());
	}
	
	@Test
	public void consultarTodasCachedTest(){
		List<Escuela> escuelas = escuelaDao.consultarTodosCached();
		Assert.assertEquals(2, escuelas.size());
	}

    @Test
    public void guardarTest(){
        escuelaDao.guardar(escuela);
        Assert.assertNotNull(escuela.getId());
    }

    @Test
    public void consultarPorAntiguedadTest(){
        List<Escuela> consulta = escuelaDao.consultarPorAntiguedad(32);
        Assert.assertEquals(1, consulta.size());
    }

    @Test
    public void modificarPorNombreTest(){
        Escuela escuelaMod = new Escuela("Escuela Secundaria No. 99", 50);
        escuelaDao.modificarPorNombre(escuelaMod);

        List<Escuela> consulta = escuelaDao.consultarPorAntiguedad(50);
        Assert.assertFalse(consulta.isEmpty());
    }
}
