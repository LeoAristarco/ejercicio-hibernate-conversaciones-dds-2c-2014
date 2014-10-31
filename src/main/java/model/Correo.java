package model;

import javax.persistence.*;

@Entity
public class Correo extends EntidadPersistente {

	private String correo;

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	
}
