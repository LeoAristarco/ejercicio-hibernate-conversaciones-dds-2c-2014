package model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("chat")
public class Chat extends Conversacion {
	
	@ManyToOne
	@JoinColumn(name="primero_id")
	private Usuario primerParticipante;
	
	@ManyToOne
	@JoinColumn(name="segundo_id")
	private Usuario segundoParticipante;

	public Usuario getPrimerParticipante() {
		return primerParticipante;
	}

	public void setPrimerParticipante(Usuario primerParticipante) {
		this.primerParticipante = primerParticipante;
	}

	public Usuario getSegundoParticipante() {
		return segundoParticipante;
	}

	public void setSegundoParticipante(Usuario segundoParticipante) {
		this.segundoParticipante = segundoParticipante;
	}

}
