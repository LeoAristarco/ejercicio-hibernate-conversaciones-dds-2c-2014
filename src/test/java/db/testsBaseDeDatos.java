package db;

import java.sql.Date;

import model.Mensaje;
import model.Usuario;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class testsBaseDeDatos {

	@Test
	public void contextUp() {
		EntityManagerHelper.getEntityManager();
	}

	@Test
	public void contextUpWithTransaction() throws Exception {
		EntityManagerHelper.withTransaction(() -> {
		});
	}

	@Before
	public void begin() throws Exception {
		EntityManagerHelper.beginTransaction();
	}

	@After
	public void tearDown() throws Exception {
		EntityManagerHelper.commit();
	}
	
	@Test
	public void persistoUsuario() {
		Usuario usuario = new Usuario();
		usuario.setNombre("Santiago");
		usuario.setCorreo("santiago@santiago.com");
		
		EntityManagerHelper.persist(usuario);
	}
	
	@Test
	public void persistoMensajeSinUsuario() {
		Mensaje mensaje = new Mensaje();
		mensaje.setTexto("Mi texto");
		mensaje.setFecha(Date.valueOf("2010-10-10"));
		
		EntityManagerHelper.persist(mensaje);
	}
}
