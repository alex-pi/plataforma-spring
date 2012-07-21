package mx.sep.sajja.web.controller;

import mx.sep.seguridad.servicios.MenuSeguridadServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/seguridad/menu")
public class MenuSeguridadController {

	@Autowired
	private MenuSeguridadServicio menuSeguridadServicio;
	
	@RequestMapping(value="/modulos", method=RequestMethod.GET)
	public Object obtenerModulos(){
		return null;
	}
}
