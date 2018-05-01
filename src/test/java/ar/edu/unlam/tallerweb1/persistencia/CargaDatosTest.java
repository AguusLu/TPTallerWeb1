package ar.edu.unlam.tallerweb1.persistencia;

import org.aspectj.lang.annotation.Before;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ar.edu.unlam.tallerweb1.SpringTest;
import static org.assertj.core.api.Assertions.*;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.modelo.Barrio;
import ar.edu.unlam.tallerweb1.modelo.Comuna;
import ar.edu.unlam.tallerweb1.modelo.Direccion;
import ar.edu.unlam.tallerweb1.modelo.Farmacia;

@SuppressWarnings("unused")
public class CargaDatosTest {
	private Session session;
	
	//Carga de datos para los Test
	public void cargaDatos(){	
	
	Farmacia Farmacia1 = new Farmacia("Machado","333","Lunes");
	Farmacia Farmacia2 = new Farmacia("Ranchos","2222","Martes");
	Farmacia Farmacia3 = new Farmacia("Ceballos","448","Miercoles");
	Farmacia Farmacia4 = new Farmacia("Rojas","11111","Martes"); 
	Farmacia Farmacia5 = new Farmacia("Rivadavia","7777","Martes"); 
	Farmacia Farmacia6 = new Farmacia("Munilla","4444","Martes"); 
	
	((Session) session).save(Farmacia1);
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
	
	
	
	Direccion Direccion1 = new Direccion("Machad","3333",Barrio2);
	Direccion Direccion2 = new Direccion("Moreno","1177",Barrio1);
	Direccion Direccion3 = new Direccion("Codoba","5954",Barrio4); 
	Direccion Direccion4 = new Direccion("Rojas","5000",Barrio1); 
	Direccion Direccion5 = new Direccion("Machado","900",Barrio1); 
	Direccion Direccion6 = new Direccion("Sarmiento","10954",Barrio6); 
	
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

	
	

}
