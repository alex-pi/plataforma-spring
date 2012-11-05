package test.mx.sep.sajja.dao;

import java.util.List;

import mx.sep.sajja.dao.EscuelaDao;
import mx.sep.sajja.modelo.Escuela;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EscuelaDaoTest extends BaseDaoTest {
	
	@Autowired
	private EscuelaDao escuelaDao;
	
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
}
