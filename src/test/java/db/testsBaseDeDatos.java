package db;

import java.sql.Date;

import model.Chat;
import model.Correo;
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
	public void persistoCorreo() {
		Correo correo = new Correo();
		correo.setCorreo("santiago@santiago.com");
		
		EntityManagerHelper.persist(correo);
	}
	
	@Test
	public void persistoUsuario() {
		Correo correo = new Correo();
		correo.setCorreo("santiago@santiago.com");
		
		Usuario usuario = new Usuario();
		usuario.setNombre("Santiago");
		usuario.setCorreo(correo);
		
		EntityManagerHelper.persist(correo);
		EntityManagerHelper.persist(usuario);
	}

	@Test
	public void persistoMensaje() {
		Correo correo = new Correo();
		correo.setCorreo("santiago@santiago.com");
		
		Usuario usuario = new Usuario();
		usuario.setNombre("Santiago");
		usuario.setCorreo(correo);
		
		Mensaje mensaje = new Mensaje();
		mensaje.setTexto("Mi texto");
		mensaje.setFecha(Date.valueOf("2010-10-10"));
		mensaje.setUsuario(usuario);

		EntityManagerHelper.persist(correo);
		EntityManagerHelper.persist(usuario);
		EntityManagerHelper.persist(mensaje);
	}
	
	@Test
	public void persistoChar() {
		Chat chat = new Chat();
		
		EntityManagerHelper.persist(chat);
	}
}
