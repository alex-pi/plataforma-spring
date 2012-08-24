package mx.sep.sajja.web.controller;

import mx.sep.seguridad.modelo.UsuarioSeguridad;
import mx.sep.seguridad.servicios.SeguridadServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ejercicios")
public class EjerciciosController {
	
	@Autowired
	private SeguridadServicio seguridadServicio;

	@RequestMapping(value = "/usuarios/guardar", method=RequestMethod.POST)
	@ResponseBody
	public Long guardarFormulario(@RequestBody UsuarioSeguridad usuario) {
		seguridadServicio.registrarUsuario(usuario);
		
		return usuario.getId();
	}
}
