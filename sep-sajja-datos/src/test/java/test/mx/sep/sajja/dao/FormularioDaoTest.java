package test.mx.sep.sajja.dao;

import mx.sep.sajja.dao.FormularioDao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class FormularioDaoTest extends BaseDaoTest {
	
	@Autowired
	private FormularioDao formularioDao;
	
	@Test
	public void ejemploTest(){
		Assert.notNull(formularioDao);
	}
}
