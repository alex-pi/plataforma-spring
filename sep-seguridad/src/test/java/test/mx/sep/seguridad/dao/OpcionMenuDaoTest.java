package test.mx.sep.seguridad.dao;

import java.util.List;

import mx.sep.seguridad.dao.OpcionMenuDao;
import mx.sep.seguridad.modelo.OpcionMenu;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import test.mx.sep.seguridad.SeguridadBaseTest;

public class OpcionMenuDaoTest extends SeguridadBaseTest {
	
	@Autowired
	private OpcionMenuDao opcionMenuDao;
	
	@Test
	public void dependenciaTest(){
		Assert.notNull(opcionMenuDao);
	}
	
	@Test
	public void consultarTodosTest(){
		List<OpcionMenu> opciones =
				opcionMenuDao.consultarTodos();
		
		Assert.notEmpty(opciones);
	}

	@Test
	public void consultarOpcionTest(){
		OpcionMenu opcion =
				opcionMenuDao.consultarOpcion(1l);
		
		Assert.notNull(opcion);
	}
	
	@Test
	public void consultarOpcionesHijasTest(){
		List<OpcionMenu> opciones =
				opcionMenuDao.consultarOpcionesHijas(1l);
		
		Assert.notEmpty(opciones);
	}	
	
	@Test
	public void consultarOpcionSubOpciones(){
		OpcionMenu opcion =
				opcionMenuDao.consultarOpcionSubOpciones(1l);
		
		Assert.notNull(opcion);
		Assert.notEmpty(opcion.getOpciones());
	}	
	
}
