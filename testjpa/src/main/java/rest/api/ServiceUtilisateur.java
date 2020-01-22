package rest.api;

import domain.Utilisateur;

import java.util.List;

public interface ServiceUtilisateur {

    List<Utilisateur> getUtilisateurs();

    void addUtilisateur();

}
