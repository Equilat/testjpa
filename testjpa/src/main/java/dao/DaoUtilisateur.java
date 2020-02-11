package dao;

import domain.Utilisateur;

import java.util.List;

public class DaoUtilisateur {


    public List<Utilisateur> findAll() {
        return EntityManagerHelper.getEntityManager().createQuery("select u from Utilisateur as u", Utilisateur.class).getResultList();
    }

    public List<Utilisateur> findByMail(String mail) {
        return EntityManagerHelper.getEntityManager().createQuery("select u from Utilisateur as u where u.mail = :mail", Utilisateur.class)
                .setParameter("mail", mail).getResultList();
    }

    public Utilisateur createUser(Utilisateur utilisateur) {
        EntityManagerHelper.beginTransaction();
        if (utilisateur.getMail() != null) {
            EntityManagerHelper.getEntityManager().merge(utilisateur);
        } else {
            EntityManagerHelper.getEntityManager().persist(utilisateur);
        }
        EntityManagerHelper.commit();
        return utilisateur;
    }

    public void deleteUser(String mail) {
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().remove(this.findByMail(mail));
        EntityManagerHelper.commit();
    }
}