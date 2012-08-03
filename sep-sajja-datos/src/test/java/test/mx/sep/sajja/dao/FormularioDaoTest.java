package test.mx.sep.sajja.dao;

import mx.sep.sajja.dao.FormularioDao;
import mx.sep.sajja.modelo.Formulario;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class FormularioDaoTest extends BaseDaoTest {
	
	@Autowired
	private FormularioDao formularioDao;
	
	@Test
	public void ejemploTest(){
		Assert.assertNotNull(formularioDao);
	}
	
	@Test
	public void guardarFormularioTest(){
		
		Formulario formulario = new Formulario();

		
		formulario.setApellido("Hernandez");
		formulario.setEmail("b@b.com");
		formulario.setNombre("brian");
		formulario.setPassword("12345");
		formulario.setTelefono("56548287");
		
		Integer id = formularioDao.guardarFormulario(formulario);
		
		
		Assert.assertEquals(new Integer(1), id);
		Assert.assertNotNull(formulario.getId());
	}
	
	@Test
	public void consultarFormularioByIdTest(){
		
	
		Formulario formulario = formularioDao.consultarFormulario(new Long(9));
		Assert.assertNotNull(formulario);
		
	}
}
