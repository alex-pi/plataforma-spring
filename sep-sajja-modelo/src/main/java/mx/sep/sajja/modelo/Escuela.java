package mx.sep.sajja.modelo;

public class Escuela extends BaseModelo {

	private String nombre;
	private Integer antiguedad;
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Integer getAntiguedad() {
		return antiguedad;
	}
	
	public void setAntiguedad(Integer antiguedad) {
		this.antiguedad = antiguedad;
	}
	
}
