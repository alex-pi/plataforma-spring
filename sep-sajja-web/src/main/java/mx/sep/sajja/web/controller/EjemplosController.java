package mx.sep.sajja.web.controller;

import mx.sep.sajja.servicios.EjemploServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/ejemplos")
public class EjemplosController {

	@Autowired
	private EjemploServicio ejemploServicio;
	
	@RequestMapping("/modulo")
	public String moduloSimple() throws InterruptedException{
		Thread.sleep(7000);
		return new String("ejemplo");
	}
	
	@RequestMapping(value= "/controllerFormulario", method = RequestMethod.POST)
	public ModelAndView formulario() {
		return new ModelAndView("ejemplos/formulario");
	}	
	
//	@RequestMapping("/controllerJsp")
	public ModelAndView vistaDesdeController() {
		return new ModelAndView("ejemplos/controllerJsp","datoModelo", "Despachado por controller");
	}
}
