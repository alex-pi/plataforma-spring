package test.mx.sep.sajja.servicios;

import java.util.List;

import mx.sep.sajja.modelo.ModuloMenu;
import mx.sep.sajja.servicios.MenuSeguridadServicio;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class MenuSeguridadServicioImplTest extends BaseServicioTest {
	
	@Autowired
	private MenuSeguridadServicio menuSeguridadServicio;

	@Test
	public void dependenciaTest(){
		Assert.notNull(menuSeguridadServicio);
	}
	
	@Test
	public void consultarModulosTest(){
		List<ModuloMenu> modulos = menuSeguridadServicio.consultarModulos();
		
		Assert.notEmpty(modulos);
	}
}
