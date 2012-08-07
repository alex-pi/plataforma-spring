package mx.sep.seguridad.dao;

import java.util.List;

import mx.sep.seguridad.modelo.RolSeguridad;
import mx.sep.seguridad.modelo.UsuarioSeguridad;

/**
 * Servicios de acceso a datos para roles y usuario de seguridad.
 * 
 * @author Alejandro Pimentel
 *
 */
public interface SeguridadDao {

	List<UsuarioSeguridad> consultarUsarios();
	
	List<RolSeguridad> consultarRoles();
	
	UsuarioSeguridad consultarUsuarioConRoles(String username);
}
