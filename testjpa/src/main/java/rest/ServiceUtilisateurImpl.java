package rest;

import dao.DaoUtilisateur;
import domain.Utilisateur;
import rest.api.ServiceUtilisateur;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.logging.Logger;

@Path("/user")
public class ServiceUtilisateurImpl implements ServiceUtilisateur {

    private static final Logger logger = Logger.getLogger(ServiceUtilisateurImpl.class.getName());

    private DaoUtilisateur daoUtilisateur;

    public ServiceUtilisateurImpl() {
        this.daoUtilisateur = new DaoUtilisateur();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public List<Utilisateur> getAllUtilisateurs() {
        return daoUtilisateur.findAll();
    }

    @GET
    @Path("/{mail}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public List<Utilisateur> getUtilisateurByMail(@PathParam("mail") String mail) {
        return daoUtilisateur.findByMail(mail);
    }

    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public Utilisateur addUtilisateur(Utilisateur utilisateur) {
        return this.daoUtilisateur.createUser(utilisateur);
    }

    @DELETE
    @Path("/{mail}")
    @Override
    public void removeUtilisateur(@PathParam("mail") String mail) {
        daoUtilisateur.deleteUser(mail);
    }
}