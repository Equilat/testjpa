package rest.api;

import domain.Reunion;

import java.util.List;

public interface ServiceReunion {

    public List<Reunion> findAll();

    public List<Reunion> findById(long id);

    public Reunion createReunion(Reunion reunion);

//    public void deleteReunion(long id);

}
