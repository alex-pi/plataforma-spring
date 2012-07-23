package test.mx.sep.seguridad.dao;

import java.util.List;

import mx.sep.seguridad.dao.ModuloMenuDao;
import mx.sep.seguridad.modelo.ModuloMenu;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import test.mx.sep.seguridad.SeguridadBaseTest;

public class ModuloMenuDaoTest extends SeguridadBaseTest {
	
	@Autowired
	private ModuloMenuDao moduloMenuDao;
	
	@Test
	public void dependenciaTest(){
		Assert.notNull(moduloMenuDao);
	}
	
	@Test
	public void consultarTodosTest(){
		List<ModuloMenu> opciones =
				moduloMenuDao.consultarTodos();
		
		Assert.notEmpty(opciones);
	}
	
	@Test
	public void consultarModulo(){
		ModuloMenu opcion =
				moduloMenuDao.consultarModulo(6l);
		
		Assert.notNull(opcion);
	}

}
