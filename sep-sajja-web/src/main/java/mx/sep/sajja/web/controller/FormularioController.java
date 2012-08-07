package mx.sep.sajja.web.controller;

import mx.sep.sajja.modelo.Formulario;
import mx.sep.sajja.servicios.FormularioServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "/formulario") 
public class FormularioController {   
	
	@Autowired
	private FormularioServicio formularioServicio;
	
	@RequestMapping(value = "/guardar", method=RequestMethod.POST)
	@ResponseBody
	public Long guardarFormulario(@ModelAttribute("formulario") Formulario formulario) {
		formularioServicio.guardarFormulario(formulario);
		
		return formulario.getId();
	}
	
	@RequestMapping(value = "/guardar/json", method=RequestMethod.POST)
	@ResponseBody
	public Long guardarFormularioJson(@RequestBody Formulario formulario) {
		formularioServicio.guardarFormulario(formulario);
		
		return formulario.getId();
	}
}

