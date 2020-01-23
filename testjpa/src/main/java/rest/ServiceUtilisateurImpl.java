package rest;

import dao.EntityManagerHelper;
import domain.Utilisateur;
import rest.api.ServiceUtilisateur;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/hello")
public class ServiceUtilisateurImpl implements ServiceUtilisateur {
//    @GET
//    @Produces(MediaType.TEXT_PLAIN)
//    public String sayHello() {
//        return "Hello, how are you?";
//    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public List<Utilisateur> getUtilisateurs() {
        return EntityManagerHelper.getEntityManager().createQuery("select u from Utilisateur as u", Utilisateur.class).getResultList();
    }

    @Override
    public void addUtilisateur() {

    }
}