package mx.sep.seguridad.util;

import mx.sep.seguridad.modelo.UsuarioSeguridad;
import mx.sep.seguridad.servicios.CustomUserDetails;

import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Métodos de utilería para interactuar con el módulo de seguridad.
 * 
 * @author Alejandro Pimentel
 *
 */
public class SeguridadUtil {

	/**
	 * Trata de obtener la información del usuario autenticado para el hilo
	 * de ejecución actual.
	 * 
	 * Si no le es posible obtenerlo lanza un {@link RuntimeException}
	 * 
	 * @return Un objeto tipo {@link UsuarioSeguridad}
	 */
    public static UsuarioSeguridad getUsuarioActual() {
        if(SecurityContextHolder.getContext().
                getAuthentication() == null
           || !SecurityContextHolder.getContext().
                getAuthentication().
                getPrincipal().
                getClass().
                equals(CustomUserDetails.class)) {
            throw new RuntimeException("La sesión actual no ha sido autenticada", null);
        }

        CustomUserDetails cud = (CustomUserDetails) SecurityContextHolder.getContext().
                getAuthentication().
                getPrincipal();
        
        UsuarioSeguridad us = new UsuarioSeguridad(cud.getUsername(), "", cud.getNombre(), cud.isEnabled());
        
        return us;
    }
}
