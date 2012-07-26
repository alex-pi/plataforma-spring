package mx.sep.seguridad.servicios;

import java.util.Collection;

import mx.sep.seguridad.modelo.UsuarioSeguridad;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomUserDetails extends User {

	private static final long serialVersionUID = 310L;
	
	public CustomUserDetails(UsuarioSeguridad us, Collection<? extends GrantedAuthority> authorities){
		super(us.getUsername(), us.getPassword(), us.isActivo(), true, true, true, authorities);
	}
}
