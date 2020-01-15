package jpa;

import domain.*;

import javax.persistence.*;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import domain.Utilisateur;

public class JpaTest {

    private EntityManager manager;

    public JpaTest(EntityManager manager) {
        this.manager = manager;
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("mysql");
        EntityManager manager = factory.createEntityManager();
        JpaTest test = new JpaTest(manager);
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {
            test.createUtilisateurs();
        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();


        test.createUtilisateurs();

        manager.close();
        factory.close();
    }

    private void createUtilisateurs() {
        PrefsAlimentaires prefsAlimentairesUser1 = new PrefsAlimentaires();
        prefsAlimentairesUser1.addAllergy("arachide");
        prefsAlimentairesUser1.addAliment("pizza");
        prefsAlimentairesUser1.addAliment("nems");
        manager.persist(prefsAlimentairesUser1);
        Utilisateur utilisateur1 = new Utilisateur("emile.georget@hotmail.com", "Emile", "Georget", prefsAlimentairesUser1);
        manager.persist(utilisateur1);
        PrefsAlimentaires prefsAlimentairesUser2 = new PrefsAlimentaires();
        prefsAlimentairesUser1.addAllergy("Lactose");
        prefsAlimentairesUser1.addAliment("Salade");
        manager.persist(prefsAlimentairesUser2);
        Utilisateur utilisateur2 = new Utilisateur("helene.heinle@hotmail.com", "Heinle", "Hélène", prefsAlimentairesUser2);
        manager.persist(utilisateur2);
    }
}
