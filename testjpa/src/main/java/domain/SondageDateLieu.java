package domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@Entity
@DiscriminatorValue("date_lieu")
public class SondageDateLieu extends Sondage {

    private List<DateReu> datesReu;
    private List<String> lieux;

    public SondageDateLieu() {
    }

    public SondageDateLieu(String lienWeb, List<String> lieux) {
        super(lienWeb);
        this.lieux = lieux;
        this.datesReu = new ArrayList<DateReu>();
    }

    @OneToMany(mappedBy = "sondage")
    public List<DateReu> getDatesReu() {
        return datesReu;
    }

    public void setDatesReu(List<DateReu> datesReus) {
        this.datesReu = datesReus;
    }

    @Transient
    public List<String> getLieux() {
        return this.lieux;
    }

    @Transient
    public void setLieux(List<String> lieux) {
        this.lieux = lieux;
    }

    //* ces getter/setter sont pour JPA
    protected String getLieuxBase() {
        // pour mettre la liste en base, on transforme notre liste
        // en chaine du type : "carotte;courgette"
        StringBuilder res = new StringBuilder();
        for (String s : this.lieux) {
            res.append(s).append(";");
        }
        return res.toString();
    }

    protected void setLieuxBase(String lieu) {
        //on recoit "carotte;courgette", on re constitue notre liste
        StringTokenizer s = new StringTokenizer(lieu, ";");
        this.lieux = new ArrayList<String>();
        while (s.hasMoreElements()) {
            this.lieux.add(s.nextToken());
        }
    }
}
