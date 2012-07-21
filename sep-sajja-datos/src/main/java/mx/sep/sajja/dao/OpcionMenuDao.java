package mx.sep.sajja.dao;

import java.util.List;

import mx.sep.sajja.modelo.OpcionMenu;

public interface OpcionMenuDao {

	List<OpcionMenu> consultarTodos();

	List<OpcionMenu> consultarOpcionesHijas(Long idPadre);
	
	OpcionMenu consultarOpcion(Long id);
	
	OpcionMenu consultarOpcionModulo(Long id);
}