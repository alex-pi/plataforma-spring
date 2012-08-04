package mx.sep.seguridad.servicios;

import java.util.List;

import mx.sep.seguridad.dao.ModuloMenuDao;
import mx.sep.seguridad.dao.OpcionMenuDao;
import mx.sep.seguridad.modelo.ModuloMenu;
import mx.sep.seguridad.modelo.OpcionMenu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase de servicio que permite acceder a la información del Menú de opciones.
 * 
 * @author Alejandro Pimentel
 *
 */
@Service
public class MenuSeguridadServicioImpl implements MenuSeguridadServicio {

	@Autowired
	private ModuloMenuDao moduloMenuDao;
	@Autowired
	private OpcionMenuDao opcionMenuDao;

	/**
	 * 
	 * {@inheritDoc}
	 */
	public List<ModuloMenu> consultarModulos() {
		List<ModuloMenu> modulos = moduloMenuDao.consultarTodos();
		
		return modulos;
	}

	public OpcionMenu consultarOpcionSubOpciones(Long idPadre) {
		return opcionMenuDao.consultarOpcionSubOpciones(idPadre);
	}
	
	public ModuloMenu consultarModuloMenu(Long idModulo){
		return moduloMenuDao.consultarModulo(idModulo);
	}
}
