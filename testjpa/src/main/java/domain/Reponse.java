package domain;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;

public class Reponse {

    private List<Utilisateur> utilisateurs;
    private List<Date> dates;

    @ManyToMany (mappedBy = "reponses")
    public List<Utilisateur> getUtilisateurs() {
        return this.utilisateurs;
    }

    public void setUtilisateurs() {
        this.utilisateurs = utilisateurs;
    }

    @OneToMany
    @JoinColumn(name = "id")
    public List<Date> getDates() {
        return dates;
    }

    public void setDates(List<Date> dates) {
        this.dates = dates;
    }
}
