package mx.sep.sajja.web.controller;

import mx.sep.sajja.servicios.EjemploServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ejemplos")
public class EjemploController {

	@Autowired
	private EjemploServicio ejemploServicio;
	
	@RequestMapping("/modulo")
	public String moduloSimple() throws InterruptedException{
		Thread.sleep(4000);
		return new String("ejemplo");
	}
}
