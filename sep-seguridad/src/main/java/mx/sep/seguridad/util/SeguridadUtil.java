package mx.sep.seguridad.util;

import mx.sep.seguridad.modelo.UsuarioSeguridad;
import mx.sep.seguridad.servicios.CustomUserDetails;

import org.springframework.security.core.context.SecurityContextHolder;

public class SeguridadUtil {

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
