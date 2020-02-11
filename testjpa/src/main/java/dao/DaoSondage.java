package dao;

import domain.Sondage;
import domain.SondageLieu;

import java.util.List;

public class DaoSondage {


    public List<Sondage> findAll() {
        return EntityManagerHelper.getEntityManager().createQuery("select s from Sondage as s", Sondage.class).getResultList();
    }

    public List<Sondage> findById(String id) {
        return EntityManagerHelper.getEntityManager().createQuery("select s from Sondage as s where s.id = :id", Sondage.class)
                .setParameter("id", id).getResultList();
    }

//    public List<Sondage> getSondagesFromType(String type) {
//        return EntityManagerHelper.getEntityManager().createQuery("select s from Sondage as s where s. = :type", Sondage.class)
//                .setParameter("type", type).getResultList();
//    }

    public Sondage createSondageLieu(SondageLieu sondageLieu) {
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(sondageLieu);
        EntityManagerHelper.commit();
        return sondageLieu;
    }

    public void deleteSondage(String id) {
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().remove(this.findById(id));
        EntityManagerHelper.commit();
    }
}