package test.mx.sep.sajja.servicios;

import mx.sep.sajja.servicios.FormularioServicio;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class FormularioServicioImplTest extends BaseServicioTest {
	
	@Autowired
	private FormularioServicio formularioServicio;

	@Test
	public void formularioServicioDependenciaTest(){
		Assert.notNull(formularioServicio);
	}
}
