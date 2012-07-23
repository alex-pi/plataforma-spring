package mx.sep.seguridad.servicios;

import java.util.List;

import mx.sep.seguridad.modelo.ModuloMenu;
import mx.sep.seguridad.modelo.OpcionMenu;

public interface MenuSeguridadServicio {

	List<ModuloMenu> consultarModulos();
	
	OpcionMenu consultarOpcionSubOpciones(Long idPadre);
	
	ModuloMenu consultarModuloMenu(Long idModulo);
}
