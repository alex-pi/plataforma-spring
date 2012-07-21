package test.mx.sep.sajja.dao;

import java.util.List;

import mx.sep.sajja.dao.OpcionMenuDao;
import mx.sep.sajja.modelo.OpcionMenu;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class OpcionMenuDaoTest extends BaseDaoTest {
	
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
	public void consultarOpcionModuloTieneModuloTest(){
		OpcionMenu opcion =
				opcionMenuDao.consultarOpcionModulo(1l);
		
		Assert.notNull(opcion);
		Assert.notNull(opcion.getModuloMenu());
	}	
	
	@Test
	public void consultarOpcionModuloNoTieneModuloTest(){
		OpcionMenu opcion =
				opcionMenuDao.consultarOpcionModulo(2l);
		
		Assert.notNull(opcion);
		// Sólo las opciones de primer nivel (sub-modulos) tienen módulo asignado.
		// Pero a consecuencia de la referencia circular el objeto módulo se crea con una lista de
		// opciones espuria :P
		Assert.isNull(opcion.getModuloMenu().getId());
	}	
	
	@Test
	public void consultarOpcionesHijas(){
		List<OpcionMenu> opciones =
				opcionMenuDao.consultarOpcionesHijas(1l);
		
		Assert.notEmpty(opciones);
	}	
	
}
