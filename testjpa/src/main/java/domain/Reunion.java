package domain;

import javax.persistence.*;

@Entity
public class Reunion {

	private long id;
	private DateReu dateReuFixee;
	private String intitule;
	private String resume;

	public Reunion() {

	}

	public Reunion(String intitule, String  resume) {
		this.intitule = intitule;
		this.resume = resume;
	}

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}

	@ManyToOne
	public DateReu getDateReuFixee() {
		return dateReuFixee;
	}
	public void setDateReuFixee(DateReu dateReuFixee) {
		this.dateReuFixee = dateReuFixee;
	}
	


}
