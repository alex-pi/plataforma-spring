package test.mx.sep.seguridad.dao;

import java.util.List;

import mx.sep.seguridad.dao.SeguridadDao;
import mx.sep.seguridad.modelo.RolSeguridad;
import mx.sep.seguridad.modelo.UsuarioSeguridad;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import test.mx.sep.seguridad.SeguridadBaseTest;

public class SeguridadDaoTest extends SeguridadBaseTest {
	
	@Autowired
	private SeguridadDao seguridadDao;
	
	@Test
	public void dependenciaTest(){
		Assert.assertNotNull(seguridadDao);
	}
	
	@Test
	public void consultarUsariosTest(){
		List<UsuarioSeguridad> usuarios =
				seguridadDao.consultarUsarios();
		
		Assert.assertFalse(usuarios.isEmpty());
	}
	
	@Test
	public void consultarUsuarioConRolesTest(){
		UsuarioSeguridad usuario =
				seguridadDao.consultarUsuarioConRoles("brian");
		
		Assert.assertNotNull(usuario);
		Assert.assertFalse(usuario.getRoles().isEmpty());
		Assert.assertEquals(2 ,usuario.getRoles().size());
	}
	
	@Test
	public void consultarRolesYRolSeguridad(){
		List<RolSeguridad> roles = seguridadDao.consultarRoles();
		
		Assert.assertEquals(3 , roles.size());
	}
	
	@Test
	public void registrarUsuarioTest(){
		UsuarioSeguridad prueba = 
				new UsuarioSeguridad("prueba", "sdsads", "prueba", true);
		seguridadDao.registrar(prueba);
		
		Assert.assertNotNull(prueba.getId());
	}
}
