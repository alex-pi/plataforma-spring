package test.mx.sep.seguridad.util;

import mx.sep.seguridad.modelo.UsuarioSeguridad;
import mx.sep.seguridad.util.SeguridadUtil;

import org.junit.Assert;
import org.junit.Test;

import test.mx.sep.seguridad.SeguridadBaseTest;

public class SeguridadUtilTest extends SeguridadBaseTest {

	@Test
	public void getUsuarioActualTest(){
		UsuarioSeguridad usuario = SeguridadUtil.getUsuarioActual();
		
		Assert.assertNotNull(usuario);
	}
}
