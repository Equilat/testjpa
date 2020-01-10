package jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import domain.Utilisateur;

public class JpaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("mysql");
		EntityManager manager = factory.createEntityManager();

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {

			Utilisateur p = new Utilisateur();
			p.setMail("martin2@mail.com");
			manager.persist(p);




		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		String s = "SELECT e FROM Utilisateur as e where e.mail=:mail";

		Query q = manager.createQuery(s, Utilisateur.class);
		q.setParameter("mail", "martin2@mail.com"); 
		List<Utilisateur> res = q.getResultList();

		System.err.println(res.size());
		System.err.println(res.get(0).getMail());

		manager.close();
		factory.close();
	}

}
