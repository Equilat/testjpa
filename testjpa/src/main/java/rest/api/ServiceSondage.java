package rest.api;

import domain.Sondage;
import domain.SondageDate;
import domain.SondageDateLieu;
import domain.SondageLieu;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

public interface ServiceSondage {

    public List<Sondage> findAll();

    public List<Sondage> findById(String id);

//    public List<Sondage> getSondagesFromType(String type);

    public Sondage createSondageLieu(SondageLieu sondageLieu);

    @POST
    @Path("/date")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Sondage createSondageDate(SondageDate sondageDate);

    @POST
    @Path("/dateLieu")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Sondage createSondageDateLieu(SondageDateLieu sondageDateLieu);

    public void deleteSondage(String id);


}
