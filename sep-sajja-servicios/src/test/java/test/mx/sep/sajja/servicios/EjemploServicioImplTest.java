package test.mx.sep.sajja.servicios;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import mx.sep.sajja.servicios.EjemploServicio;
import mx.sep.sajja.servicios.util.ErrorNegocio;

public class EjemploServicioImplTest extends BaseServicioTest {
	
	@Autowired
	private EjemploServicio ejemploServicio;

	@Test
	public void ejemploServicioDependenciaTest(){
		Assert.notNull(ejemploServicio);
	}
	
	@Test(expected=ErrorNegocio.class)
	public void ejemploMensajeErrorNegocioTest(){
		ejemploServicio.ejemploCodigoMensajeErrorNegocio();
	}
}
