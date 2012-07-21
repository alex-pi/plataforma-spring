package mx.sep.sajja.modelo;

public class OpcionMenu extends BaseModelo{

	private String opcion;
	private String descripcion;
	private String url;
	private ModuloMenu moduloMenu;

	public String getOpcion() {
		return opcion;
	}
	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public ModuloMenu getModuloMenu() {
		return moduloMenu;
	}
	public void setModuloMenu(ModuloMenu moduloMenu) {
		this.moduloMenu = moduloMenu;
	}
	
	@Override
	public String toString() {
		return "OpcionMenu [opcion=" + opcion + ", descripcion=" + descripcion
				+ ", url=" + url + ", moduloMenu=" + moduloMenu.getId() + ", getId()="
				+ getId() + "]";
	}
	
}
