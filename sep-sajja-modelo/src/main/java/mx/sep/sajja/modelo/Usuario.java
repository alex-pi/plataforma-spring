package mx.sep.sajja.modelo;

import java.util.Date;

public class Usuario extends BaseModelo {
	
	String nombre;
	String apellido;
	String email;
	String password;
	String telefono;
    Date fecha;

    public Usuario(String nombre, String apellido, String email, String password, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.telefono = telefono;
    }

    public Usuario() {
    }

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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
	public String toString() {
		return "Archivo [nombre=" + nombre + ", apellidoPaterno="
				+ apellido + ", correo="	+ email 
				+ ", password=" + password 
				+ ", telefono=" + telefono +", getId()=" + getId() + "]";
	}
}
