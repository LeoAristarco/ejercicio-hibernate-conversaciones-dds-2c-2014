package model;

import javax.persistence.Entity;

@Entity
public class Usuario extends EntidadPersistente {

	private String correo;
	
	private String nombre;
	
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
