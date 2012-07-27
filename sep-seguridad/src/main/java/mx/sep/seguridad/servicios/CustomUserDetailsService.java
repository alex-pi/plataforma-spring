package mx.sep.seguridad.servicios;

import java.util.HashSet;
import java.util.Set;

import mx.sep.seguridad.dao.SeguridadDao;
import mx.sep.seguridad.modelo.RolSeguridad;
import mx.sep.seguridad.modelo.UsuarioSeguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private SeguridadDao seguridadDao;
	
	protected final MessageSourceAccessor messages = SpringSecurityMessageSource.getAccessor();
	
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		UsuarioSeguridad us = seguridadDao.consultarUsuarioConRoles(username);
		
		if(us == null){
            throw new UsernameNotFoundException("Usuario " + username + " no encontrado");			
		}
		if(us.getRoles() == null || us.getRoles().size() == 0){
			throw new UsernameNotFoundException("Usuario " + username + " no tiene authorties (roles)");
		}
		
		Set<GrantedAuthority> dbAuthsSet = new HashSet<GrantedAuthority>();
		
		for (RolSeguridad rol : us.getRoles()) {
			if(rol.isActivo())
				dbAuthsSet.add(new CustomGrantedAuthority(rol));
		}
		return new CustomUserDetails(us, dbAuthsSet);
	}

}
