package model;

import java.sql.Date;

import javax.persistence.*;

@Entity
public class Mensaje extends EntidadPersistente {
	
	private String texto;
	
	private Date fecha;
	
	@Transient
	private Usuario usuario;

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
