package test.mx.sep.sajja.servicios;

import java.util.List;

import mx.sep.sajja.modelo.Escuela;
import mx.sep.sajja.servicios.CatalogosServicio;
import mx.sep.sajja.servicios.util.CatalogosEnum;
import net.sf.ehcache.CacheManager;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CatalogosServicioImplTest extends BaseServicioTest {
	
	@Autowired
	private CatalogosServicio catsServicio;
	
	@Autowired
	private CacheManager cacheManager;

	@Before
	public void before(){
		Assert.assertNotNull(catsServicio);
		Assert.assertNotNull(cacheManager);
		cacheManager.getCache("cacheCatalogos").flush();
	}
	
	@After
	public void after(){
		cacheManager.getCache("cacheCatalogos").flush();
	}
	
	@Test
	public void consultaEscuelasTest(){
		List<Escuela> escuelas = catsServicio.consultarEscuelas(CatalogosEnum.ESCUELAS);
		
		Assert.assertEquals(2, escuelas.size());
		CacheTestHelper.assertCacheContains(cacheManager, "cacheCatalogos", CatalogosEnum.ESCUELAS, escuelas);
	}

}
