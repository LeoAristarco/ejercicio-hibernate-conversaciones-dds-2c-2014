package model;

import javax.persistence.*;

@Entity
public class Usuario extends EntidadPersistente {

	@OneToOne
	@JoinColumn(name="correo_id")
	private Correo correo;
	
	private String nombre;
	
	public Correo getCorreo() {
		return correo;
	}
	public void setCorreo(Correo correo) {
		this.correo = correo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
