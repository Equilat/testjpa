package domain;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Locale;

@Entity
public class DateReu {

	private long id;
	private boolean pause;
	private List<Reunion> reunions;
	private List<Sondage> sondages;
	private Date sqlDate;

	public DateReu() {

	}

	public DateReu(String dateReu, boolean pause) {
		reunions = new ArrayList<Reunion>();
		sondages = new ArrayList<Sondage>();
		try {
			DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE);
			java.util.Date date = format.parse(dateReu);
			sqlDate = new Date(date.getTime());
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		this.pause = pause;
	}
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isPause() {
		return pause;
	}

	public void setPause(boolean pause) {
		this.pause = pause;
	}

	@OneToMany (mappedBy = "dateReuFixee")
	public List<Reunion> getReunions() {
		return this.reunions;
	}

	public void setReunions(List<Reunion> reunions) {
		this.reunions = reunions;
	}

	public void addReunion(Reunion reunion) {
		this.reunions.add(reunion);
	}

	public Date getSqlDate() {
		return this.sqlDate;
	}

	@ManyToMany (mappedBy = "dateReus")
	public List<Sondage> getSondages() {
		return this.sondages;
	}

	public void setSondages(List<Sondage> sondages) {
		this.sondages = sondages;
	}

	public void setSqlDate(Date sqlDate) {
		this.sqlDate = sqlDate;
	}

}
