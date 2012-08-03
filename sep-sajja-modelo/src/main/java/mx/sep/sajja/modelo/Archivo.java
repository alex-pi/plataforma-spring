package mx.sep.sajja.modelo;

public class Archivo extends BaseModelo {
	
	String nombre;
	String ruta;
	byte[] datos;	
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	
	
	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public byte[] getDatos() {
		return datos;
	}
	
	public void setDatos(byte[] datos) {
		this.datos = datos;
	}

	@Override
	public String toString() {
		return "Archivo [nombre=" + nombre + ", datos="
				+ datos + ", getId()=" + getId() + "]";
	}
}
