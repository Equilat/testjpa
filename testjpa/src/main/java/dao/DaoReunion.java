package dao;

import domain.Reunion;

import java.util.List;

public class DaoReunion {


    public List<Reunion> findAll() {
        return EntityManagerHelper.getEntityManager().createQuery("select r from Reunion as r", Reunion.class).getResultList();
    }

    public List<Reunion> findById(String id) {
        return EntityManagerHelper.getEntityManager().createQuery("select r from Reunion as r where r.id = :id", Reunion.class)
                .setParameter("id", id).getResultList();
    }

    public Reunion createReunion(Reunion reunion) {
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(reunion);
        EntityManagerHelper.commit();
        return reunion;
    }

    public void deleteReunion(String id) {
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().remove(this.findById(id));
        EntityManagerHelper.commit();
    }

}
