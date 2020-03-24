package domain;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("date")
@JsonIgnoreProperties(ignoreUnknown = true)
public class SondageDate extends Sondage {

    private List<DateReu> datesReu;

    public SondageDate() {
    }

    public SondageDate(String lienWeb) {
        super(lienWeb);
    }

    @OneToMany(mappedBy = "sondage", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    public List<DateReu> getDatesReu() {
        return datesReu;
    }

    public void setDatesReu(List<DateReu> datesReus) {
        this.datesReu = datesReus;
    }

}
