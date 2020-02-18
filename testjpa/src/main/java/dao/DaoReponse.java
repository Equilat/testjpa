package dao;

import domain.Reponse;

import java.util.List;

public class DaoReponse {


    public List<Reponse> findAll() {
        return EntityManagerHelper.getEntityManager().createQuery("select r from Reponse as r", Reponse.class).getResultList();
    }

    public List<Reponse> findById(String id) {
        return EntityManagerHelper.getEntityManager().createQuery("select r from Reponse as r where r.id = :id", Reponse.class)
                .setParameter("id", id).getResultList();
    }

    public Reponse createReponse(Reponse reponse) {
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(reponse);
        EntityManagerHelper.commit();
        return reponse;
    }

    public void deleteReponse(String id) {
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().remove(this.findById(id));
        EntityManagerHelper.commit();
    }


}
