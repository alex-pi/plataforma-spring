package mx.sep.seguridad.modelo;

import java.util.List;

public class ModuloMenu extends BaseModelo{

	private String modulo;
	private List<OpcionMenu> opcionesMenu;

	public String getModulo() {
		return modulo;
	}
	public void setModulo(String modulo) {
		this.modulo = modulo;
	}
	public List<OpcionMenu> getOpcionesMenu() {
		return opcionesMenu;
	}
	public void setOpcionesMenu(List<OpcionMenu> opcionesMenu) {
		this.opcionesMenu = opcionesMenu;
	}
	
	@Override
	public String toString() {
		return "ModuloMenu [modulo=" + modulo + ", opcionesMenu="
				+ opcionesMenu + ", getId()=" + getId() + "]";
	}
	
}
