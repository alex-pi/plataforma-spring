package mx.sep.sajja.web.controller;

import java.util.ArrayList;
import java.util.List;

import mx.sep.seguridad.modelo.ModuloMenu;
import mx.sep.seguridad.modelo.OpcionMenu;
import mx.sep.seguridad.servicios.MenuSeguridadServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/seguridad/menu")
public class MenuSeguridadController {

	@Autowired
	private MenuSeguridadServicio menuSeguridadServicio;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	@ResponseBody
	public OpcionMenu obtenerOpciones(@PathVariable Long id){
		OpcionMenu opcion = menuSeguridadServicio.consultarOpcionSubOpciones(id);
		
		for (OpcionMenu op : opcion.getOpciones()) {
			if(!StringUtils.hasLength(op.getUrl())){
				// con un arreglo vacío indicamos que tiene hijos
				// que posteriormente podrían ser cargados.
				op.setOpciones(new ArrayList<OpcionMenu>());
			}
		}
		
		return opcion;
	}
	
	@RequestMapping(value="/modulo/{id}", method=RequestMethod.GET)
	@ResponseBody
	public OpcionMenu obtenerModulo(@PathVariable Long id){
		ModuloMenu modulo = menuSeguridadServicio.consultarModuloMenu(id);
		OpcionMenu opcion = new OpcionMenu();
		opcion.setId(modulo.getId());
		opcion.setOpcion(modulo.getModulo());
		// con un arreglo vacío indicamos que tiene hijos
		// que posteriormente podrían ser cargados.		
		opcion.setOpciones(new ArrayList<OpcionMenu>());
		
		return opcion;
	}	
	
	@RequestMapping(value="/modulos", method=RequestMethod.GET)
	@ResponseBody
	public List<ModuloMenu> obtenerModulos(){
		List<ModuloMenu> modulos = menuSeguridadServicio.consultarModulos();
		
		return modulos;
	}	
	
}
