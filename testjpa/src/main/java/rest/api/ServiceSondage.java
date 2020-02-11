package rest.api;

import domain.Sondage;
import domain.SondageLieu;

import java.util.List;

public interface ServiceSondage {

    public List<Sondage> findAll();

    public List<Sondage> findById(String id);

//    public List<Sondage> getSondagesFromType(String type);

    public Sondage createSondageLieu(SondageLieu sondageLieu);

    public void deleteSondage(String id);


}
