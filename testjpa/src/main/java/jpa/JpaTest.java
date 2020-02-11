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
    private Utilisateur utilisateur;
    private SondageDate sondage;

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

        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();

        manager.close();
        factory.close();
    }
}
