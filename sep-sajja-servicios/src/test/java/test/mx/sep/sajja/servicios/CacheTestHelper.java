package test.mx.sep.sajja.servicios;

import java.util.List;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.junit.Assert;
import org.springframework.util.StringUtils;

/**
 * Clase de utilería para probar contra el ehcache.
 * 
 * @author Alejandro Pimentel
 *
 */
public class CacheTestHelper {

	public static <T> void assertCacheContains(CacheManager cacheManager, String cacheName, T obj) {

		if (!StringUtils.hasText(cacheName))
			throw new IllegalArgumentException("Debe proporcionar un nombre de cache");

		if (obj == null)
			throw new IllegalArgumentException("El objeto a buscar no debe ser nulo");

		Cache cache = cacheManager.getCache(cacheName);
		Assert.assertNotNull(cache);
		Assert.assertNotNull(cache.getKeys());
		Assert.assertNotNull(cache.getKeys().get(0));

		Element element = cache.get(cache.getKeys().get(0));

		Assert.assertNotNull(element);
		Assert.assertNotNull(element.getValue());

		if (element.getValue() instanceof List) {
			List<T> fromCache = (List<T>) element.getValue();

			Assert.assertNotNull(fromCache);
			Assert.assertTrue(fromCache.size() > 0);

		} else {
			Assert.assertEquals(obj, element.getValue());
		}
	}
	
	public static <T,K> void assertCacheContains(CacheManager cacheManager, String cacheName, K key, T obj) {

		if (!StringUtils.hasText(cacheName))
			throw new IllegalArgumentException("Debe proporcionar un nombre de cache");

		if (obj == null)
			throw new IllegalArgumentException("El objeto a buscar no debe ser nulo");
		
		if (key == null)
			throw new IllegalArgumentException("La llave no debe ser nula");

		Cache cache = cacheManager.getCache(cacheName);
		Assert.assertNotNull(cache);
		Assert.assertNotNull(cache.getKeys());
		Assert.assertNotNull(key);

		Element element = cache.get(key);

		Assert.assertNotNull(element);
		Assert.assertNotNull(element.getValue());

		if (element.getValue() instanceof List) {
			List<T> fromCache = (List<T>) element.getValue();

			Assert.assertNotNull(fromCache);
			Assert.assertTrue(fromCache.size() > 0);

		} else {
			Assert.assertEquals(obj, element.getValue());
		}
	}	
	
}
