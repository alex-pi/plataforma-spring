package test.mx.sep.sajja.servicios;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import mx.sep.sajja.servicios.EjemploServicio;

public class EjemploServicioTest extends BaseServicioTest {
	
	@Autowired
	private EjemploServicio ejemploServicio;

	@Test
	public void ejemploServicioDependenciaTest(){
		Assert.notNull(ejemploServicio);
	}
}
