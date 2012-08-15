package mx.sep.sajja.servicios;

import java.util.List;

import mx.sep.sajja.dao.UsuarioDao;
import mx.sep.sajja.datos.vo.FiltroBusquedaVO;
import mx.sep.sajja.modelo.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsuarioServicioImpl implements UsuarioServicio {

	@Autowired
	private UsuarioDao usuarioDao;
	
	public List<Usuario> consultarModulos() {
		return usuarioDao.consultarTodos();
	}

	public Long guardarFormulario(Usuario u) {
		usuarioDao.guardar(u);
		
		return u.getId();
	}	

	public List<Usuario> buscar(){
		return usuarioDao.consultarTodos();
	}
	
	public List<Usuario> buscar(FiltroBusquedaVO filtroBusquedaVO){
		return usuarioDao.consultarPaginados(filtroBusquedaVO);
	}
	
	public Integer contar(){
		return usuarioDao.contar();
	}
}
