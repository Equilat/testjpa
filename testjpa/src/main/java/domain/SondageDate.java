package domain;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("date")
public class SondageDate extends Sondage {

    private List<DateReu> datesReus;

    public SondageDate() {
    }

    public SondageDate(String lienWeb) {
        super(lienWeb);
    }

//    @ManyToMany (mappedBy = "dateReus", cascade = CascadeType.MERGE)
//    public List<DateReu> getDateReus() {
//        return dateReus;
//    }
//
//    public void setDateReus(List<DateReu> dateReus) {
//        this.dateReus = dateReus;
//    }

    @OneToMany(mappedBy = "sondage")
    public List<DateReu> getDatesReus() {
        return datesReus;
    }

    public void setDatesReus(List<DateReu> datesReus) {
        this.datesReus = datesReus;
    }

}
