package mx.sep.sajja.dao;

import java.util.List;

import mx.sep.sajja.modelo.Archivo;

public interface ArchivoDao {
	
	List<Archivo> consultarTodos();
	void guardarArchivo(Archivo archivo);

}
