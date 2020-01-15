package domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class SondageDate extends Sondage {

    private List<DateReu> dateReus;

    public SondageDate() {
    }

    public SondageDate(String lienWeb) {
        super(lienWeb);
    }

    @OneToMany
    public List<DateReu> getDateReus() {
        return dateReus;
    }

    public void setDateReus(List<DateReu> dateReus) {
        this.dateReus = dateReus;
    }

}
