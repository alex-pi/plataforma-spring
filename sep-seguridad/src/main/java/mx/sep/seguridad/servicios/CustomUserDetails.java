package mx.sep.seguridad.servicios;

import java.util.Collection;

import mx.sep.seguridad.modelo.UsuarioSeguridad;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Una extensión de la implementación de referencia {@link User} de la interfaz {@link UserDetails}
 * que provee Spring.
 * 
 * Esta extesión nos permite tener un nombre completo del Usuario/Principal además de crear instancias de
 * esta clase a partir de un objeto de modelo {@link UsuarioSeguridad}.
 * 
 * @author Alejandro Pimentel
 *
 */
public class CustomUserDetails extends User {

	private static final long serialVersionUID = 310L;
	
	private String nombre;
	
	/**
	 * 
	 * 
	 * @param us Objeto de modelo con información del usuario/principal.
	 * @param authorities la lista de autorizaciones que se brindan al usuario/principal.
	 */
	public CustomUserDetails(UsuarioSeguridad us, Collection<? extends GrantedAuthority> authorities){
		super(us.getUsername(), us.getPassword(), us.isActivo(), true, true, true, authorities);
		this.nombre = us.getNombre();
	}

	/**
	 * Nombre o identificador más detallado del Usuario/Principal.
	 * 
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}
	
}
