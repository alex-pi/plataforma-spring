package test.mx.sep.sajja.dao;

import java.util.List;

import mx.sep.sajja.dao.UsuarioDao;
import mx.sep.sajja.datos.vo.FiltroBusquedaVO;
import mx.sep.sajja.modelo.Usuario;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UsuarioDaoTest extends BaseDaoTest {
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	@Test
	public void ejemploTest(){
		Assert.assertNotNull(usuarioDao);
	}
	
	@Test
	public void guardarFormularioTest(){
		Usuario usuario = new Usuario();
		usuario.setApellido("Hernandez");
		usuario.setEmail("b@b.com");
		usuario.setNombre("brian");
		usuario.setPassword("12345");
		usuario.setTelefono("56548287");
		
		Integer id = usuarioDao.guardar(usuario);
		
		Assert.assertEquals(new Integer(1), id);
		Assert.assertNotNull(usuario.getId());
	}
	
	@Test
	public void consultarFormularioByIdTest(){
		Usuario usuario = usuarioDao.consultar(new Long(1));

		Assert.assertNotNull(usuario);
	}
	
	@Test
	public void consultarPaginadosTest(){
		FiltroBusquedaVO vo = new FiltroBusquedaVO(0, 2, "nombre", "asc");
		List<Usuario> usuarios = usuarioDao.consultarPaginados(vo);
		
		Assert.assertFalse(usuarios.isEmpty());
		Assert.assertEquals(2, usuarios.size());
	}
	
	@Test
	public void contarTest(){
		Integer cuenta = usuarioDao.contar();
		
		Assert.assertEquals(new Integer(4), cuenta);
	}
}
