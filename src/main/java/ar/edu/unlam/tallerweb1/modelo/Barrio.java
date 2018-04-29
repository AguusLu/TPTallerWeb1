package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Id;

public class Barrio {

	private String nombre;
	@Id
	private long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Barrio(String nombre) {
		this.setNombre(nombre);
	}

}
