package mx.sep.seguridad.dao;

import java.util.List;

import mx.sep.seguridad.modelo.OpcionMenu;

public interface OpcionMenuDao {

	List<OpcionMenu> consultarTodos();

	List<OpcionMenu> consultarOpcionesHijas(Long idPadre);
	
	OpcionMenu consultarOpcion(Long id);
	
	OpcionMenu consultarOpcionModulo(Long id);
}