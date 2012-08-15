package mx.sep.sajja.servicios;

import java.util.List;

import mx.sep.sajja.datos.vo.FiltroBusquedaVO;
import mx.sep.sajja.modelo.Usuario;

public interface UsuarioServicio {
	
	List<Usuario> consultarModulos();
	
	Long guardarFormulario(Usuario u);
	
	List<Usuario> buscar();
	
	List<Usuario> buscar(FiltroBusquedaVO filtroBusquedaVO);
	
	Integer contar();

}
