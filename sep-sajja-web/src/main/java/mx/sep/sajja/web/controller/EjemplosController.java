package mx.sep.sajja.web.controller;

import mx.sep.sajja.servicios.EjemploServicio;
import mx.sep.sajja.servicios.UsuarioServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Todos los controllers deben llevar el estereotipo {@link Controller} y opcionalmente
 * por medio de {@link RequestMapping} indicar un path base para todas
 * las peticiones que atenderá este controller.
 * 
 * @author Alejandro Pimentel
 *
 */
@Controller
@RequestMapping("/ejemplos")
public class EjemplosController {

	@Autowired
	private EjemploServicio ejemploServicio;
	
	/**
	 * El método además de devolver una vista espera unos segundos para
	 * mostrar en el navegador el indicador de espera para la carga de la pantalla.
	 * 
	 * @return Un objeto String que corresponde al nombre de una vista
	 * @throws InterruptedException
	 */
	@RequestMapping("/modulo")
	public String moduloSimple() throws InterruptedException{
		Thread.sleep(7000);
		return new String("ejemplos/ejemplo");
	}
	
	
	/**
	 * Al resivir la petición con path ejemplos/controllerJsp Spring primero
	 * intentará resolverla con este método de controller.
	 * 
	 * Si este no se encuentra (por ejemplo comentado la instrucción @RequestMapping),
	 * Spring tratará de resolver ese path como una vista. (Devolviendo diréctamente lo
	 * generado por el JSP).
	 * 
	 * Por el contrario si no se comenta la anotación mencionada este método atenderá la petición.
	 * Cuando esto pasa, se devolverá la misma vista pero añadiendo el mensaje "Despachado por controller".
	 * 
	 * @return Un objeto ModelAndView, donde la vista es "ejemplos/controllerJsp" y el modelo es una simple
	 * 			variable datoModelo="Despachado por controller"
	 */
	@RequestMapping("/controllerJsp")
	public ModelAndView vistaDesdeController() {
		return new ModelAndView("ejemplos/controllerJsp","datoModelo", "Pasé por el controller");
	}
	
	/**
	 * Llama métodos de servicio que provocan excepciones creadas de distintos modos para ilustrar
	 * el manejo de errores de la aplicación.
	 * 
	 * @param ejemplo Dependiendo del valor de este parámetro se llamará un método distintito de
	 *    		nuestro bean de Servicio.
	 */
	@RequestMapping(value= "/error/simple/{ejemplo}", method = RequestMethod.GET)
	public void ejemploManejoErrorNegocio(@PathVariable Integer ejemplo) {
		
		if(ejemplo.equals(1)){
			ejemploServicio.ejemploMensajeErrorNegocio();
		} else if(ejemplo.equals(2)){
			ejemploServicio.ejemploCodigoMensajeErrorNegocio();
		}
	}	
}
