package mx.sep.sajja.dao;

import java.util.List;

import mx.sep.sajja.datos.vo.FiltroBusquedaVO;
import mx.sep.sajja.modelo.Usuario;

public interface UsuarioDao {
	
	List<Usuario> consultarTodos();
	
	Usuario consultar(Long id);
	
	Integer guardar(Usuario usuario);
	
	List<Usuario> consultarPaginados(FiltroBusquedaVO filtroBusquedaVO);
	
	Integer contar();

}
