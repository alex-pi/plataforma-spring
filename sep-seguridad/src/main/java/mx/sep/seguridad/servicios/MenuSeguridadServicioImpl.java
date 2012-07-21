package mx.sep.seguridad.servicios;

import java.util.List;

import mx.sep.seguridad.dao.ModuloMenuDao;
import mx.sep.seguridad.modelo.ModuloMenu;
import mx.sep.seguridad.servicios.MenuSeguridadServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuSeguridadServicioImpl implements MenuSeguridadServicio {

	@Autowired
	private ModuloMenuDao moduloMenuDao;

	public List<ModuloMenu> consultarModulos() {
		return moduloMenuDao.consultarTodos();
	}

}
