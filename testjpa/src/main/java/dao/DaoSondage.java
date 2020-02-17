package dao;

import domain.Sondage;
import domain.SondageDate;
import domain.SondageDateLieu;
import domain.SondageLieu;

import java.util.List;

public class DaoSondage {


    public List<Sondage> findAll() {
        return EntityManagerHelper.getEntityManager().createQuery("select s from Sondage as s", Sondage.class).getResultList();
    }

    public List<Sondage> findById(long id) {
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

    public Sondage createSondageDate(SondageDate sondageDate) {
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(sondageDate);
        EntityManagerHelper.commit();
        return sondageDate;
    }

    public Sondage createSondageDateLieu(SondageDateLieu sondageDateLieu) {
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(sondageDateLieu);
        EntityManagerHelper.commit();
        return sondageDateLieu;
    }

    public void deleteSondage(long id) {
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().remove(this.findById(id));
        EntityManagerHelper.commit();
    }
}