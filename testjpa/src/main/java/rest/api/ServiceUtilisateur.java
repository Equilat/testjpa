package rest.api;

import domain.Utilisateur;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

public interface ServiceUtilisateur {

    List<Utilisateur> getAllUtilisateurs();


    List<Utilisateur> getUtilisateurByMail(String mail);

    void addUtilisateur(Utilisateur utilisateur);

}
