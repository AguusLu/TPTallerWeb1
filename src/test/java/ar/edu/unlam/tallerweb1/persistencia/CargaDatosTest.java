
package ar.edu.unlam.tallerweb1.persistencia;

import ar.edu.unlam.tallerweb1.SpringTest;
import org.junit.Before;
import static org.assertj.core.api.Assertions.*;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.modelo.Barrio;
import ar.edu.unlam.tallerweb1.modelo.Direccion;
import ar.edu.unlam.tallerweb1.modelo.Farmacia;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

//Extiendo para que sepa que tiene que manejarse con SpringTest//
public class CargaDatosTest extends SpringTest {
	private Session session;

	// Carga de datos para los Test
	@Before //Le aclaro el Before para que ejecute esto antes que nada//
	public void cargaDatos() {
		session = this.getSession();

		Farmacia Farmacia1 = new Farmacia("Machado", "333", "Lunes");
		Farmacia Farmacia2 = new Farmacia("Ranchos", "2222", "Martes");
		Farmacia Farmacia3 = new Farmacia("Ceballos", "448", "Miercoles");
		Farmacia Farmacia4 = new Farmacia("Rojas", "11111", "Martes");
		Farmacia Farmacia5 = new Farmacia("Rivadavia", "7777", "Martes");
		Farmacia Farmacia6 = new Farmacia("Munilla", "4444", "Martes");

		session.save(Farmacia1);
		session.save(Farmacia2);
		session.save(Farmacia3);
		session.save(Farmacia4);
		session.save(Farmacia5);
		session.save(Farmacia6);

		Barrio Barrio1 = new Barrio("Moron");
		Barrio Barrio2 = new Barrio("Castelar");
		Barrio Barrio3 = new Barrio("Ramos");
		Barrio Barrio4 = new Barrio("Palermo");
		Barrio Barrio5 = new Barrio("VillaCrespo");
		Barrio Barrio6 = new Barrio("Flores");

		session.save(Barrio3);
		session.save(Barrio1);
		session.save(Barrio2);
		session.save(Barrio4);
		session.save(Barrio5);
		session.save(Barrio6);

		Direccion Direccion1 = new Direccion("Machado", "3333", Barrio2);
		Direccion Direccion2 = new Direccion("Moreno", "1177", Barrio1);
		Direccion Direccion3 = new Direccion("Codoba", "5954", Barrio4);
		Direccion Direccion4 = new Direccion("Rojas", "5000", Barrio1);
		Direccion Direccion5 = new Direccion("Machado", "900", Barrio1);
		Direccion Direccion6 = new Direccion("Sarmiento", "10954", Barrio6);

		session.save(Direccion1);
		session.save(Direccion2);
		session.save(Direccion3);
		session.save(Direccion4);
		session.save(Direccion5);
		session.save(Direccion6);

		Farmacia1.setDireccion(Direccion1);
		Farmacia2.setDireccion(Direccion2);
		Farmacia3.setDireccion(Direccion3);
		Farmacia4.setDireccion(Direccion4);
		Farmacia5.setDireccion(Direccion5);
		Farmacia6.setDireccion(Direccion6);
	}

	// 2- Hacer con junit un test que busque todas las farmacias de turno los días
	// martes.
	@Test
	@Transactional
	@Rollback(true)
	@SuppressWarnings("unchecked")

	public void buscarMartesTest() {

		List<Farmacia> listaFarmacia;
		listaFarmacia = session.createCriteria(Farmacia.class).add(Restrictions.eq("diaDeTurno", "Martes")).list();
		
		
		assertThat(listaFarmacia.size()).isEqualTo(4);
	}

	// 3- Hacer con junit un test que busque todas las farmacias de una calle.
	@Test
	@Transactional
	@Rollback(true)
	@SuppressWarnings("unchecked")

	public void buscarCalleTest() {

		List<Farmacia> listaFarmacia;
		listaFarmacia = session.createCriteria(Farmacia.class).createAlias("direccion", "direccionBuscada")
				.add(Restrictions.eq("direccionBuscada.calle", "Machado")).list();

		//primero es el atributo y despues el alias y en el siguiente inner el alias con la calle literal
		assertThat(listaFarmacia.size()).isEqualTo(2);
	}

	// 4- Hacer con junit un test que busque todas las farmacias de un barrio.
	@Test
	@Transactional
	@Rollback(true)
	@SuppressWarnings("unchecked")
	public void buscarMismoBarrioTest() {
		List<Farmacia> listaFarmacia;
		listaFarmacia = session.createCriteria(Farmacia.class).createAlias("direccion", "direccionBuscada")
				.createAlias("direccionBuscada.barrio", "barrioBuscado")
				.add(Restrictions.eq("barrioBuscado.nombre", "Castelar")).list();
		assertThat(listaFarmacia.size()).isEqualTo(1);
	}

}
