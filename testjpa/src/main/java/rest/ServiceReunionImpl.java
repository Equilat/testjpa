package rest;

import dao.DaoReunion;
import domain.Reunion;
import rest.api.ServiceReunion;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/meeting")
public class ServiceReunionImpl implements ServiceReunion {

    private DaoReunion daoReunion;

    public ServiceReunionImpl() {
        this.daoReunion = new DaoReunion();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public List<Reunion> findAll() {
        return daoReunion.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public List<Reunion> findById(@PathParam("id") String id) {
        return daoReunion.findById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Reunion createReunion(Reunion reunion) {
        return daoReunion.createReunion(reunion);
    }

    @DELETE
    @Path("/{id}")
    @Override
    public void deleteReunion(String id) {
        daoReunion.deleteReunion(id);
    }
}
