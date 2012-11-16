package mx.sep.seguridad.servicios;

import java.util.List;

import mx.sep.seguridad.dao.SeguridadDao;
import mx.sep.seguridad.modelo.UsuarioSeguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MttoSeguridadServicioImpl implements MttoSeguridadServicio{

	@Autowired
	private SeguridadDao seguridadDao;
	
	public List<UsuarioSeguridad> consultarUsuarios() {
		return seguridadDao.consultarUsuarios();
	}

	public List<UsuarioSeguridad> consultarUsuariosConRoles() {
		return seguridadDao.consultarUsuariosConRoles();
	}
}
