package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy =
        InheritanceType.SINGLE_TABLE)
public abstract class Sondage {

    private long id;
    private String lienWeb;
    private List<Utilisateur> utilisateurs;
    private Reunion reunion;

    public Sondage() {

    }

    public Sondage(String lienWeb) {
        this.lienWeb = lienWeb;
        this.utilisateurs = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLienWeb() {
        return lienWeb;
    }

    public void setLienWeb(String lienWeb) {
        this.lienWeb = lienWeb;
    }

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "UTILISATEUR_SONDAGE",
            joinColumns = @JoinColumn(name = "SONDAGES_ID"),
            inverseJoinColumns = @JoinColumn(name = "UTILISATEURS_MAIL"))
    public List<Utilisateur> getUtilisateurs() {
        return this.utilisateurs;
    }

    public void setUtilisateurs(List<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }

    @OneToOne
    public Reunion getReunion() {
        return this.reunion;
    }

    public void setReunion(Reunion reunion) {
        this.reunion = reunion;
    }

    public void addUtilisateur(Utilisateur utilisateur) {
        this.utilisateurs.add(utilisateur);
    }


}
