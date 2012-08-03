package mx.sep.sajja.servicios;

import java.util.List;

import mx.sep.sajja.modelo.Archivo;

public interface ArchivoServicio {
	
	List<Archivo> consultarModulos();
	void insertarArchivo(Archivo archivo);

}
