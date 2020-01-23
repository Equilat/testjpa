package jpa;

import domain.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import domain.Utilisateur;

public class JpaTest {

    private EntityManager manager;
    private Utilisateur utilisateur1;
    private Utilisateur utilisateur2;
    private SondageDate sondage1;
    private SondageLieu sondage2;
    private SondageDateLieu sondage3;

    public JpaTest(EntityManager manager) {
        this.manager = manager;
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("dev");
        EntityManager manager = factory.createEntityManager();
        JpaTest test = new JpaTest(manager);
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {
            test.createUtilisateurs();
            test.createPrefAlimentaires();
            test.createSondage();
            test.createDate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();

        manager.close();
        factory.close();
    }

    private void createUtilisateurs() {
        utilisateur1 = new Utilisateur("emile.georget@hotmail.com", "Emile", "Georget");
        manager.persist(utilisateur1);
        utilisateur2 = new Utilisateur("helene.heinle@hotmail.com", "Heinle", "Hélène");
        manager.persist(utilisateur2);
    }

    private void createPrefAlimentaires() {
    	PrefsAlimentaires prefsAlimentaires1 = new PrefsAlimentaires(Arrays.asList("pizza", "cheeseburger"), Arrays.asList("Arachide", "Lactose"));
    	manager.persist(prefsAlimentaires1);
    	utilisateur1.setPrefsAlimentaires(prefsAlimentaires1);
    	PrefsAlimentaires prefsAlimentaires2 = new PrefsAlimentaires(Arrays.asList("salade", "sushis"), Arrays.asList("Beurre de cacahuète"));
		manager.persist(prefsAlimentaires2);
		utilisateur2.setPrefsAlimentaires(prefsAlimentaires2);

	}

	private void createSondage() {
		sondage1 = new SondageDate("http://www.google.com");
		manager.persist(sondage1);
		sondage2 = new SondageLieu("http://www.google.com", Arrays.asList("Paris", "Rennes"));
		manager.persist(sondage2);
		sondage3 = new SondageDateLieu("http://www.google.com", Arrays.asList("Brest", "Montpellier"));
		manager.persist(sondage3);
		utilisateur1.addSondages(Arrays.asList(sondage1, sondage3));
		utilisateur2.addSondages(Arrays.asList(sondage2));
	}

	private void createDate() {
        DateReu dateReu1 = new DateReu("25/03/2020", false);
        manager.persist(dateReu1);
        DateReu dateReu2 = new DateReu("23/07/2020", true);
        manager.persist(dateReu2);
        DateReu dateReu3 = new DateReu("05/04/2020", true);
        manager.persist(dateReu3);
        DateReu dateReu4 = new DateReu("27/08/2020", false);
        manager.persist(dateReu4);
        DateReu dateReu5 = new DateReu("29/03/2020", true);
        manager.persist(dateReu5);
        DateReu dateReu6 = new DateReu("15/07/2020", true);
        manager.persist(dateReu6);
        sondage1.setDateReus(Arrays.asList(dateReu1, dateReu2, dateReu3));
        sondage3.setDateReus(Arrays.asList(dateReu4, dateReu5, dateReu6));
    }

    private void createReunion(DateReu date, Sondage sondage, String strategie, String resume) {
        Reunion reunion = new Reunion(strategie, resume);
        manager.persist(reunion);
        reunion.setDateReuFixee(date);
        sondage.setReunion(reunion);
    }
}
