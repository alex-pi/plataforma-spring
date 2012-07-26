package mx.sep.seguridad.modelo;

public class RolSeguridad extends BaseModelo{

	private String rol;
	private boolean activo;
	
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public String getAuthority() {
		return this.getRol();
	}
		
}
