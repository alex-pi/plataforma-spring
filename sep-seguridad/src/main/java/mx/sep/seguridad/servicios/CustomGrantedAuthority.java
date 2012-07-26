package mx.sep.seguridad.servicios;

import mx.sep.seguridad.modelo.RolSeguridad;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.Assert;

public class CustomGrantedAuthority implements GrantedAuthority {

    private static final long serialVersionUID = 3101L;

    private final String role;
    private final boolean activo;

    public CustomGrantedAuthority(RolSeguridad rs) {
        Assert.hasText(rs.getRol(), "El rol no puede ser un texto vacío.");
        this.role = rs.getRol();
        this.activo = rs.isActivo();
    }

    public String getAuthority() {
        return role;
    }

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
