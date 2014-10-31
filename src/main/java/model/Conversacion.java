package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.IndexColumn;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "conv_tipo", discriminatorType = DiscriminatorType.STRING)
public abstract class Conversacion extends EntidadPersistente {

	@OneToMany
	@IndexColumn(name="orden")
	@JoinColumn(name="conversacion_id")
	private List<Mensaje> mensajes = new ArrayList<Mensaje>();

	public List<Mensaje> getMensajes() {
		return mensajes;
	}

	public void setMensajes(List<Mensaje> mensajes) {
		this.mensajes = mensajes;
	}
	
	public void addMensaje(Mensaje mensaje) {
		this.mensajes.add(mensaje);
	}
}
