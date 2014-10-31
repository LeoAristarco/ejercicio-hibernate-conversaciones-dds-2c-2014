package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@DiscriminatorValue("hangout")
public class Hangout extends Conversacion {

	@OneToOne
	@JoinColumn(name = "dueño_id")
	private Usuario dueño;

	@ManyToMany
	@JoinTable(name = "Usuarios_x_Hangout", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "hangout_id"))
	private List<Usuario> otrosUsuarios = new ArrayList<Usuario>();

	public Usuario getDueño() {
		return dueño;
	}

	public void setDueño(Usuario dueño) {
		this.dueño = dueño;
	}

	public List<Usuario> getOtrosUsuarios() {
		return otrosUsuarios;
	}

	public void setOtrosUsuarios(List<Usuario> otrosUsuarios) {
		this.otrosUsuarios = otrosUsuarios;
	}

	public void addUsuario(Usuario usuario) {
		this.otrosUsuarios.add(usuario);
	}
}
