package test.mx.sep.seguridad.dao;

import java.util.List;

import mx.sep.seguridad.dao.SeguridadDao;
import mx.sep.seguridad.modelo.UsuarioSeguridad;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import test.mx.sep.seguridad.SeguridadBaseTest;

public class SeguridadDaoTest extends SeguridadBaseTest {
	
	@Autowired
	private SeguridadDao seguridadDao;
	
	@Test
	public void dependenciaTest(){
		Assert.notNull(seguridadDao);
	}
	
	@Test
	public void consultarUsariosTest(){
		List<UsuarioSeguridad> usuarios =
				seguridadDao.consultarUsarios();
		
		Assert.notEmpty(usuarios);
	}
	
	@Test
	public void consultarUsuarioConRolesTest(){
		UsuarioSeguridad usuario =
				seguridadDao.consultarUsuarioConRoles("brian");
		
		Assert.notNull(usuario);
		Assert.notEmpty(usuario.getRoles());
		Assert.isTrue(usuario.getRoles().size() == 2);
	}
}
