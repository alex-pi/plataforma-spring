package mx.sep.seguridad.servicios;

import java.util.List;

import mx.sep.seguridad.modelo.UsuarioSeguridad;

public interface MttoSeguridadServicio {

	List<UsuarioSeguridad> consultarUsuarios();
	
	List<UsuarioSeguridad> consultarUsuariosConRoles();
}
