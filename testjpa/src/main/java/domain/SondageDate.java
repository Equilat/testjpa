package domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@DiscriminatorValue("date")
public class SondageDate extends Sondage {

    private List<DateReu> datesReu;

    public SondageDate() {
    }

    public SondageDate(String lienWeb) {
        super(lienWeb);
    }

    @OneToMany(mappedBy = "sondage")
    public List<DateReu> getDatesReu() {
        return datesReu;
    }

    public void setDatesReu(List<DateReu> datesReus) {
        this.datesReu = datesReus;
    }

}
