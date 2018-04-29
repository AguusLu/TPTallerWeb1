package ar.edu.unlam.tallerweb1.modelo;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Comuna {
	@Id
	private Long id;
	private String nombre;

	public Long getId() {
		return this.id;
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

	@OneToMany
	private List<Barrio> barrios = new LinkedList<Barrio>();

	// Estoy agregando de a un barrio a la lista barrios (Variable nueva creada
	// privada aca)
	public void addBarrio(Barrio barrio) {
		this.barrios.add(barrio);

	}

	// Estoy obteniendo TODOS los barrios
	public List<Barrio> getBarrios() {
		return this.barrios;
	}

	// Estoy definiendo mi lista Barrios con los barrios cargados de la clase
	// Barrio//
	public void setBarrios(List<Barrio> barrios) {
		this.barrios = barrios;
	}

}
