package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Id;

public class Comuna {
	@Id
	private long id;
	private String nombre;

	public Long getId() {
		return this.id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
