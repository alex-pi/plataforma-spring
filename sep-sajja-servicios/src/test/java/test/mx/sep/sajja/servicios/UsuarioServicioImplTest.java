package test.mx.sep.sajja.servicios;

import mx.sep.sajja.servicios.UsuarioServicio;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class UsuarioServicioImplTest extends BaseServicioTest {
	
	@Autowired
	private UsuarioServicio usuarioServicio;

	@Test
	public void usuarioServicioDependenciaTest(){
		Assert.notNull(usuarioServicio);
	}
}
