package rest;

import dao.DaoSondage;
import domain.Sondage;
import domain.SondageDate;
import domain.SondageDateLieu;
import domain.SondageLieu;
import rest.api.ServiceSondage;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.logging.Logger;

@Path("/survey")
public class ServiceSondageImpl implements ServiceSondage {

    private static final Logger logger = Logger.getLogger(ServiceSondageImpl.class.getName());


    private DaoSondage daoSondage;

    public ServiceSondageImpl() {
        this.daoSondage = new DaoSondage();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public List<Sondage> findAll() {
        return daoSondage.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public List<Sondage> findById(@PathParam("id") long id) {
        return daoSondage.findById(id);
    }

    @POST
    @Path("/lieu")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Sondage createSondageLieu(SondageLieu sondageLieu) {
        return daoSondage.createSondageLieu(sondageLieu);
    }

    @POST
    @Path("/date")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Sondage createSondageDate(SondageDate sondageDate) {
        return daoSondage.createSondageDate(sondageDate);
    }

    @POST
    @Path("/dateLieu")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Sondage createSondageDateLieu(SondageDateLieu sondageDateLieu) {
        return daoSondage.createSondageDateLieu(sondageDateLieu);
    }

    @DELETE
    @Path("/{id}")
    @Override
    public void deleteSondage(@PathParam("id") long id) {
        daoSondage.deleteSondage(id);
    }
}
