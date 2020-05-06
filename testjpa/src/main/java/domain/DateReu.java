package domain;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Entity
public class DateReu {

    private long id;
    private boolean pause = false;
    private List<Reunion> reunions;
    private Sondage sondage;
//    private List<Sondage> sondages;
    @Temporal(TemporalType.DATE)
    private java.util.Date date;

    public DateReu() {

    }

    public DateReu(String dateReu) {
        this.reunions = new ArrayList<Reunion>();
        try {
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE);
            java.util.Date date = format.parse(dateReu);
            this.date = new Date(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public DateReu(String dateReu, boolean pause) {
        this.reunions = new ArrayList<Reunion>();
        try {
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE);
            java.util.Date date = format.parse(dateReu);
            this.date = new Date(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.pause = pause;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isPause() {
        return this.pause;
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }

    @OneToMany(mappedBy = "dateReuFixee")
    public List<Reunion> getReunions() {
        return this.reunions;
    }

    public void setReunions(List<Reunion> reunions) {
        this.reunions = reunions;
    }

    public void addReunion(Reunion reunion) {
        this.reunions.add(reunion);
    }

    @ManyToOne//, targetEntity = SondageDate.class)
    public Sondage getSondage() {
        return  this.sondage;
    }

    public void setSondage(Sondage sondage) {
        this.sondage = sondage;
    }

    public java.util.Date getDate() {
        return this.date;
    }

    public void setDate(java.util.Date date) {
        this.date = date;
    }
}
