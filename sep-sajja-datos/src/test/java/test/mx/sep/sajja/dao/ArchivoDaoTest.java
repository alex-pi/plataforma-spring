package test.mx.sep.sajja.dao;

import mx.sep.sajja.dao.ArchivoDao;
import mx.sep.sajja.dao.FormularioDao;
import mx.sep.sajja.modelo.Archivo;
import mx.sep.sajja.modelo.Formulario;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ArchivoDaoTest extends BaseDaoTest {
	
	@Autowired
	private ArchivoDao archivoDao;
	
	@Test
	public void ejemploTest(){
		Assert.assertNotNull(archivoDao);
	}
	
	@Test
	public void guardarFormularioTest(){
		
		Archivo archivo = new Archivo();

	}
}
