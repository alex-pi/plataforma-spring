package test.mx.sep.sajja.dao;

import mx.sep.sajja.dao.EjemploDao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class EjemploDaoTest extends BaseDaoTest {
	
	@Autowired
	private EjemploDao ejemploDao;
	
	@Test
	public void ejemploTest(){
		Assert.notNull(ejemploDao);
	}
}
