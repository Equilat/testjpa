package rest;

import dao.EntityManagerHelper;
import domain.Utilisateur;
import rest.api.ServiceUtilisateur;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/users")
public class ServiceUtilisateurImpl implements ServiceUtilisateur {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public List<Utilisateur> getAllUtilisateurs() {
        return EntityManagerHelper.getEntityManager().createQuery("select u from Utilisateur as u", Utilisateur.class).getResultList();
    }

    @GET
    @Path("/{mail}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public List<Utilisateur> getUtilisateurByMail(@PathParam("mail") String mail) {
        return EntityManagerHelper.getEntityManager().createQuery("select u from Utilisateur as u where u.mail = :mail", Utilisateur.class)
                .setParameter("mail", mail).getResultList();
    }

    @POST
    @Override
    public void addUtilisateur(Utilisateur utilisateur) {

    }
}