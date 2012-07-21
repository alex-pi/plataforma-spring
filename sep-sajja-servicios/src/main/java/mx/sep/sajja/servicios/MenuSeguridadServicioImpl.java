package mx.sep.sajja.servicios;

import java.util.List;

import mx.sep.sajja.dao.ModuloMenuDao;
import mx.sep.sajja.modelo.ModuloMenu;

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
