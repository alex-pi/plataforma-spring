package mx.sep.sajja.servicios;
import java.util.List;

import mx.sep.sajja.dao.EscuelaDao;
import mx.sep.sajja.modelo.Escuela;
import mx.sep.sajja.servicios.util.CatalogosEnum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CatalogosServicioImpl implements CatalogosServicio {
	
	@Autowired
	private EscuelaDao escuelaDao;

	@Cacheable(value="cacheCatalogos")
	public List<Escuela> consultarEscuelas(CatalogosEnum escuelas) {
		return escuelaDao.consultarTodos();
	}
}
