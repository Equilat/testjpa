package rest;

import dao.DaoReponse;
import domain.Reponse;
import rest.api.ServiceReponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/answer")
public class ServiceReponseImpl implements ServiceReponse {

    private DaoReponse daoReponse;

    public ServiceReponseImpl() {
        this.daoReponse = new DaoReponse();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public List<Reponse> findAll() {
        return daoReponse.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public List<Reponse> findById(@PathParam("id") String id) {
        return daoReponse.findById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Reponse createReponse(Reponse Reponse) {
        return daoReponse.createReponse(Reponse);
    }

//    @DELETE
//    @Path("/{id}")
//    @Override
//    public void deleteReponse(String id) {
//        daoReponse.deleteReponse(id);
//    }
}
