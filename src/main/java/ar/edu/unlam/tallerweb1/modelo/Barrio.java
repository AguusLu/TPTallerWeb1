package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Barrio {

	@Id
	private Long id;
	private String nombre;

	public Barrio() {

	}

	public Barrio(String nombre) {
		this.nombre = nombre;

	}

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

	@ManyToOne
	private Comuna comuna;

	public Comuna getComuna() {
		return this.comuna;
	}

	public void setComuna(Comuna comuna) {
		this.comuna = comuna;
	}

}
