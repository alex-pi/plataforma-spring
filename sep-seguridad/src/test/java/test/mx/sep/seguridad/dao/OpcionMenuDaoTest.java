package test.mx.sep.seguridad.dao;

import java.util.List;

import mx.sep.seguridad.dao.OpcionMenuDao;
import mx.sep.seguridad.modelo.OpcionMenu;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import test.mx.sep.seguridad.SeguridadBaseTest;

public class OpcionMenuDaoTest extends SeguridadBaseTest {
	
	@Autowired
	private OpcionMenuDao opcionMenuDao;
	
	@Test
	public void dependenciaTest(){
		Assert.assertNotNull(opcionMenuDao);
	}
	
	@Test
	public void consultarTodosTest(){
		List<OpcionMenu> opciones =
				opcionMenuDao.consultarTodos();
		
		Assert.assertFalse(opciones.isEmpty());
	}

	@Test
	public void consultarOpcionTest(){
		OpcionMenu opcion =
				opcionMenuDao.consultarOpcion(1l);
		
		Assert.assertNotNull(opcion);
	}
	
	@Test
	public void consultarOpcionesHijasTest(){
		List<OpcionMenu> opciones =
				opcionMenuDao.consultarOpcionesHijas(1l);
		
		Assert.assertFalse(opciones.isEmpty());
	}	
	
	@Test
	public void consultarOpcionSubOpciones(){
		OpcionMenu opcion =
				opcionMenuDao.consultarOpcionSubOpciones(1l);
		
		Assert.assertNotNull(opcion);
		Assert.assertFalse(opcion.getOpciones().isEmpty());
	}	
	
}
