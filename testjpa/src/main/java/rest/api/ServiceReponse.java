package rest.api;

import domain.Reponse;

import java.util.List;

public interface ServiceReponse {

    public List<Reponse> findAll();

    public List<Reponse> findById(String id);

    public Reponse createReponse(Reponse reponse);

//    public void deleteReponse(String id);

}
