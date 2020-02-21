package domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Reponse {

    private long id;
    private Utilisateur utilisateur;
    private Sondage sondageRepondu;
    private List<DateReu> dateReus;
    private String lieu;

    @ManyToOne
    public Utilisateur getUtilisateur() {
        return this.utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public void setUtilisateur() {
        this.utilisateur = utilisateur;
    }

    @OneToMany(cascade = CascadeType.MERGE)
    public List<DateReu> getDateReus() {
        return dateReus;
    }

    public void setDateReus(List<DateReu> dateReus) {
        this.dateReus = dateReus;
    }

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @ManyToOne
    public Sondage getSondageRepondu() {
        return sondageRepondu;
    }

    public void setSondageRepondu(Sondage sondageRepondu) {
        this.sondageRepondu = sondageRepondu;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }
}
