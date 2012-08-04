package mx.sep.seguridad.servicios;

import mx.sep.seguridad.modelo.RolSeguridad;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.Assert;

/**
 * Clase que muestra cómo extender la clase de Spring Security que representa
 * una autorización/autoridad que el usuario tiene. Típicamente representados como roles.
 * 
 * Esta extensión permite la posibilidad de activar y desactivar un rol por completo.
 * 
 * @author Alejandro Pimentel
 *
 */
public class CustomGrantedAuthority implements GrantedAuthority {

    private static final long serialVersionUID = 3101L;

    private final String role;
    private final boolean activo;

    /**
     * Crea una instancia a partir de un objeto de modelo {@link RolSeguridad}
     * obtenido por algún medio. p.e. Base de datos.
     * 
     * @param rs
     */
    public CustomGrantedAuthority(RolSeguridad rs) {
        Assert.hasText(rs.getRol(), "El rol no puede ser un texto vacío.");
        this.role = rs.getRol();
        this.activo = rs.isActivo();
    }

    public String getAuthority() {
        return role;
    }

    /**
     * Indica si el rol está activo. De no ser así no será tomado
     * en cuenta a la hora de asignar los "Authorities" al Usuario.
     * 
     * @return
     */
    public boolean isActivo() {
		return activo;
	}

	public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof CustomGrantedAuthority) {
            return role.equals(((CustomGrantedAuthority) obj).role);
        }

        return false;
    }

    public int hashCode() {
        return this.role.hashCode();
    }

    public String toString() {
        return this.role;
    }

}
