package ar.edu.unlam.tallerweb1.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Comuna {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;

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

	@OneToMany
	private List<Barrio> barrios;

	// Estoy agregando de a un barrio a la lista barrios (Variable nueva creada
	// privada aca)
	public void addBarrio(Barrio barrioSelecionado) {
		this.barrios.add(barrioSelecionado);

	}

	// Estoy obteniendo TODOS los barrios
	public List<Barrio> getBarrios() {
		return barrios;
	}

	// Estoy definiendo mi lista Barrios con los barrios cargados de la clase
	// Barrio//
	public void setBarrios(List<Barrio> barrios) {
		this.barrios = barrios;
	}

}
