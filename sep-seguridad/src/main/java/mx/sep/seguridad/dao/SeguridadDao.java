package mx.sep.seguridad.dao;

import java.util.List;

import mx.sep.seguridad.modelo.RolSeguridad;
import mx.sep.seguridad.modelo.UsuarioSeguridad;

public interface SeguridadDao {

	List<UsuarioSeguridad> consultarUsarios();
	
	List<RolSeguridad> consultarRoles();
	
	UsuarioSeguridad consultarUsuarioConRoles(String username);
}
