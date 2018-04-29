package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Id;

public class Punto {
	@Id
	private Long id;
	private String latitud;
	private String longitud;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

}
