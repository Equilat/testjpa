package domain;

import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@Entity
public class SondageLieu extends Sondage {

    private List<String> lieux;

    public SondageLieu() {

    }

    public SondageLieu(String lienWeb, List<String> lieux) {
        super(lienWeb);
        this.lieux = lieux;
    }

    @Transient
    public List<String> getLieux() {
        return this.lieux;
    }

    @Transient
    public void setLieux(List<String> lieux) {
        this.lieux = lieux;
    }

    protected void setLieuxBase(String lieu) {
        //on recoit "carotte;courgette", on re constitue notre liste
        StringTokenizer s = new StringTokenizer(lieu,";");
        this.lieux = new ArrayList<String>();
        while (s.hasMoreElements()) {
            this.lieux.add(s.nextToken());

        }
    }
}
