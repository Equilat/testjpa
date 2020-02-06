package rest;

import dao.DaoSondage;
import domain.Sondage;
import domain.SondageLieu;
import rest.api.ServiceSondage;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.util.List;

@Path("/sondage")
public class ServiceSondageImpl implements ServiceSondage {

    private DaoSondage daoSondage;

    public ServiceSondageImpl() {
        this.daoSondage = new DaoSondage();
    }

    @GET
    @Path("/all")
    @Override
    public List<Sondage> findAll() {
        return daoSondage.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public List<Sondage> findById(@PathParam("id") String id) {
        return daoSondage.findById(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public Sondage createSondageLieu(SondageLieu sondageLieu) {
        return daoSondage.createSondageLieu(sondageLieu);
    }

    @DELETE
    @Path("/{id}")
    @Override
    public void deleteSondage(@PathParam("id") String id) {
        daoSondage.deleteSondage(id);
    }
}
