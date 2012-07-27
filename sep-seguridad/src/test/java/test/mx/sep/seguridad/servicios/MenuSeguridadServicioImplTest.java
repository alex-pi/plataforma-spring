package test.mx.sep.seguridad.servicios;

import java.util.List;

import mx.sep.seguridad.modelo.ModuloMenu;
import mx.sep.seguridad.servicios.MenuSeguridadServicio;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import test.mx.sep.seguridad.SeguridadBaseTest;

public class MenuSeguridadServicioImplTest extends SeguridadBaseTest {
	
	@Autowired
	private MenuSeguridadServicio menuSeguridadServicio;

	@Test
	public void dependenciaTest(){
		Assert.assertNotNull(menuSeguridadServicio);
	}
	
	@Test
	public void consultarModulosTest(){
		List<ModuloMenu> modulos = menuSeguridadServicio.consultarModulos();
		
		Assert.assertFalse(modulos.isEmpty());
		Assert.assertEquals(2, modulos.size());
	}
}
