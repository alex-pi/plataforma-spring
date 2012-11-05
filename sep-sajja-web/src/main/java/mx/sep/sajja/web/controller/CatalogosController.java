package mx.sep.sajja.web.controller;

import java.util.List;

import mx.sep.sajja.modelo.Escuela;
import mx.sep.sajja.servicios.CatalogosServicio;
import mx.sep.sajja.servicios.util.CatalogosEnum;
import mx.sep.sajja.web.util.ControllerBase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller de ejemplo para dar mantenimiento a la entidad de modelo Usuario.
 * 
 * @author Alejandro Pimentel
 *
 */
@Controller
@RequestMapping(value = "/catalogos") 
public class CatalogosController extends ControllerBase {   
	
	@Autowired
	private CatalogosServicio catsServicio;
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody	
	public List<Escuela> buscar(){
		return catsServicio.consultarEscuelas(CatalogosEnum.ESCUELAS);
	}
}

