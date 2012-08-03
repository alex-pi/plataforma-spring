package mx.sep.sajja.modelo;

public class Formulario extends BaseModelo {
	
	String nombre;
	String apellido;
	String email;
	String password;
	String telefono;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Archivo [nombre=" + nombre + ", apellidoPaterno="
				+ apellido + ", correo="	+ email 
				+ ", password=" + password 
				+ ", telefono=" + telefono +", getId()=" + getId() + "]";
	}
}
