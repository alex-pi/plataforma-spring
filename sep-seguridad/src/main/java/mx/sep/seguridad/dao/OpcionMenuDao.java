package mx.sep.seguridad.dao;

import java.util.List;

import mx.sep.seguridad.modelo.ModuloMenu;
import mx.sep.seguridad.modelo.OpcionMenu;

/**
 * Servicios de acceso a datos para la entidad de modelo {@link OpcionMenu}
 * 
 */
public interface OpcionMenuDao {

	/**
	 * Devuelve todas las entidades {@link OpcionMenu} que existan en la fuente de datos.
	 * 
	 * @return List<OpcionMenu>
	 */
	List<OpcionMenu> consultarTodos();

	/**
	 * Dado el is de un opción, devuelve todas sus opciones hijas (sub-opciones).
	 * 
	 * @param idPadre
	 * @return List<OpcionMenu>
	 */
	List<OpcionMenu> consultarOpcionesHijas(Long idPadre);
	
	/**
	 * Obtiene una {@link OpcionMenu} dado su id.
	 * 
	 * @param id
	 * @return
	 */
	OpcionMenu consultarOpcion(Long id);
	
	/**
	 * Dado un id obtiene una {@link OpcionMenu} que contiene sus opciones
	 * hijas en la propiedad {@link OpcionMenu#getOpciones()}
	 * 
	 * @param idPadre
	 * @return Una opción que contiene sus sub-opciones.
	 */
	OpcionMenu consultarOpcionSubOpciones(Long idPadre);
}