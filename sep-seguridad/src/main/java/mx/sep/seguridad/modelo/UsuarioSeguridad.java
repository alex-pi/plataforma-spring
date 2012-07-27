package mx.sep.seguridad.modelo;

import java.util.List;

public class UsuarioSeguridad extends BaseModelo{
	
	private String username;
	private String password;
	private String nombre;
	private boolean activo;
	private List<RolSeguridad> roles;	
	
	public UsuarioSeguridad(){}
	
	public UsuarioSeguridad(String username, String password, String nombre,
			boolean activo) {
		this.username = username;
		this.password = password;
		this.nombre = nombre;
		this.activo = activo;
	}	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public List<RolSeguridad> getRoles() {
		return roles;
	}
	public void setRoles(List<RolSeguridad> roles) {
		this.roles = roles;
	}
	
}
