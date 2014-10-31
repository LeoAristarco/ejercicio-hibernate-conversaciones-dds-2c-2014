package db;

import java.sql.Date;

import model.Chat;
import model.Correo;
import model.Hangout;
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
	public void persistoChat() {
		Mensaje mensaje = new Mensaje();
		mensaje.setTexto("Mi texto");
		
		Chat chat = new Chat();
		chat.addMensaje(mensaje);

		EntityManagerHelper.persist(mensaje);
		EntityManagerHelper.persist(chat);
	}
	
	@Test
	public void persistoHangout() {
		Mensaje mensaje = new Mensaje();
		mensaje.setTexto("Mi texto");
		
		Hangout hangout = new Hangout();
		hangout.addMensaje(mensaje);

		EntityManagerHelper.persist(mensaje);
		EntityManagerHelper.persist(hangout);
	}
	
	@Test
	public void persistoChatConAtributosPropios() {
		Usuario usuario1 = new Usuario();
		usuario1.setNombre("Santiago");
		
		Usuario usuario2 = new Usuario();
		usuario2.setNombre("Santiago");
		
		Mensaje mensaje = new Mensaje();
		mensaje.setTexto("Mi texto");
		
		Chat chat = new Chat();
		chat.addMensaje(mensaje);
		chat.setPrimerParticipante(usuario1);
		chat.setSegundoParticipante(usuario2);

		EntityManagerHelper.persist(usuario1);
		EntityManagerHelper.persist(usuario2);
		EntityManagerHelper.persist(mensaje);
		EntityManagerHelper.persist(chat);
	}
}
