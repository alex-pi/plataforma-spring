package mx.sep.sajja.dao;

import java.util.List;

import mx.sep.sajja.modelo.ModuloMenu;

public interface ModuloMenuDao {

	List<ModuloMenu> consultarTodos();
	
	ModuloMenu consultarModulo(Long id);
	
	ModuloMenu consultarModuloOpciones(Long id);
}
