package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//singleton
public class JpaUtil {

	private static JpaUtil instance;
	private EntityManagerFactory emf; //variabile d'istanza, l'unica istanza
	
	//costruttore privato!
	private JpaUtil() {
		emf = Persistence.createEntityManagerFactory("sportshub");
	}
	
	public static JpaUtil getInstance() {
		if (instance == null) { //succede solo alla prima chiamata
			instance = new JpaUtil();
		}
		return instance;
	}
	
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
