package test.mx.sep.sajja.dao;

import java.util.List;

import mx.sep.sajja.dao.ModuloMenuDao;
import mx.sep.sajja.modelo.ModuloMenu;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class ModuloMenuDaoTest extends BaseDaoTest {
	
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
	public void consultarModuloTest(){
		ModuloMenu opcion =
				moduloMenuDao.consultarModulo(1l);
		
		Assert.notNull(opcion);
	}
	
	@Test
	public void consultarOpcionModulo(){
		ModuloMenu opcion =
				moduloMenuDao.consultarModuloOpciones(1l);
		
		Assert.notNull(opcion);
		Assert.notEmpty(opcion.getOpcionesMenu());
	}
}
