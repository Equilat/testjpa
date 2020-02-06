package domain;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class DateReu {

	private long id;
	private boolean pause;
	private List<Reunion> reunions;
	private Date date;

	public DateReu() {

	}

	public DateReu(String dateReu, boolean pause) {
		reunions = new ArrayList<Reunion>();
		try {
			date = new SimpleDateFormat("DD/MM/YYYY").parse(dateReu);
		} catch (ParseException e) {
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
