package mx.sep.seguridad.dao;

import java.util.List;

import mx.sep.seguridad.modelo.ModuloMenu;

public interface ModuloMenuDao {

	List<ModuloMenu> consultarTodos();
	
	ModuloMenu consultarModulo(Long id);
	
	ModuloMenu consultarModuloOpciones(Long id);
}
