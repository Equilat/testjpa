package rest.api;

import domain.Utilisateur;

import java.util.List;

public interface ServiceUtilisateur {

    List<Utilisateur> getAllUtilisateurs();


    List<Utilisateur> getUtilisateurByMail(String mail);

    Utilisateur addUtilisateur(Utilisateur utilisateur);

//    void removeUtilisateur(String mail);
}
