package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Farmacia {
	@Id
	private Long id;
	private String nombre;
	private String numero;
	private String diDelTurno;

	public Farmacia() {

	}

	public Farmacia(String nombre, String numero) {
		this.setNumero(numero);
		this.setNombre(nombre);
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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDiDelTurno() {
		return diDelTurno;
	}

	public void setDiDelTurno(String diDelTurno) {
		this.diDelTurno = diDelTurno;
	}

	@OneToMany
	private Direccion direccion;

	public Direccion getDireccion() {
		return this.direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	@OneToMany
	private Punto geoLocalizacion;

	public Punto getGeoLocalizacion() {
		return this.geoLocalizacion;
	}

	public void setGeoLocalizacion(Punto geoLocalizacion) {
		this.geoLocalizacion = geoLocalizacion;
	}

}
