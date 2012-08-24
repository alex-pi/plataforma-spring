package mx.sep.seguridad.servicios;

import java.util.HashSet;
import java.util.Set;

import mx.sep.seguridad.dao.SeguridadDao;
import mx.sep.seguridad.modelo.RolSeguridad;
import mx.sep.seguridad.modelo.UsuarioSeguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Esta implementación permite obtener la información del usuario por medio de un DAO.
 * 
 * El DAO es inyectado por el contenedor de spring de modo tal que su implementación es
 * transparente a esta clase.
 * 
 * @author Alejandro Pimentel
 *
 */
public class CustomUserDetailsService 
		implements UserDetailsService, SeguridadServicio {

	@Autowired
	private SeguridadDao seguridadDao;
	
	protected final MessageSourceAccessor messages = SpringSecurityMessageSource.getAccessor();
	
	/**
	 * Obtiene la información del usuario/principal para proporcionarla (típicamente) a un {@link AuthenticationProvider}.
	 * 
	 * Esta información incluye las autorizaciones/roles que correspondan. En específico, esta implementación sólo agregará
	 * aquellos roles que esten activos.
	 * 
	 */
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		UsuarioSeguridad us = seguridadDao.consultarUsuarioConRoles(username);
		
		if(us == null){
            throw new UsernameNotFoundException("Usuario " + username + " no encontrado");			
		}
		if(us.getRoles() == null || us.getRoles().size() == 0){
			throw new UsernameNotFoundException("Usuario " + username + " no tiene autorizaciones (roles)");
		}
		
		Set<GrantedAuthority> dbAuthsSet = new HashSet<GrantedAuthority>();
		
		for (RolSeguridad rol : us.getRoles()) {
			if(rol.isActivo())
				dbAuthsSet.add(new CustomGrantedAuthority(rol));
		}
		return new CustomUserDetails(us, dbAuthsSet);
	}
	
	public void registrarUsuario(UsuarioSeguridad usuario){
		if(usuario.getUsername().equals("administrador")){
			throw new RuntimeException("No puede usar username: administrador");
		}
		seguridadDao.registrar(usuario);
	}

}
