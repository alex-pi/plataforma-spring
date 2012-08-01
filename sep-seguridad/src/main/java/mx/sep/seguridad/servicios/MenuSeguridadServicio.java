package mx.sep.seguridad.servicios;

import java.util.List;

import mx.sep.seguridad.modelo.ModuloMenu;
import mx.sep.seguridad.modelo.OpcionMenu;

import org.springframework.security.access.prepost.PostFilter;

public interface MenuSeguridadServicio {

	@PostFilter("hasPermission(filterObject, 'read')")
	List<ModuloMenu> consultarModulos();
	
	OpcionMenu consultarOpcionSubOpciones(Long idPadre);
	
	ModuloMenu consultarModuloMenu(Long idModulo);
}
