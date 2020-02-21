package rest.api;

import domain.Sondage;
import domain.SondageDate;
import domain.SondageDateLieu;
import domain.SondageLieu;

import javax.ws.rs.PathParam;
import java.util.List;

public interface ServiceSondage {

    public List<Sondage> findAll();

//    public List<Sondage> getSondagesFromType(String type);

    List<Sondage> findById(@PathParam("id") long id);

    public Sondage createSondageLieu(SondageLieu sondageLieu);

    Sondage createSondageDate(SondageDate sondageDate);

    Sondage createSondageDateLieu(SondageDateLieu sondageDateLieu);

//    public void deleteSondage(long id);


}
