package mx.sep.sajja.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.sep.sajja.dao.ArchivoDao;
import mx.sep.sajja.modelo.Archivo;


@Service
public class ArchivoServicioImpl implements ArchivoServicio {

	@Autowired
	private ArchivoDao archivoDao;
	
	public List<Archivo> consultarModulos() {
		return archivoDao.consultarTodos();
	}

	public void insertarArchivo(Archivo archivo) {
		archivoDao.guardarArchivo(archivo);
	}

}
