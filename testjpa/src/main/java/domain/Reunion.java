package domain;

import java.util.List;

import javax.persistence.*;

@Entity
public class Reunion {

	private long id;
	private Date dateFixee;
	private String intitule;
	private String resume;

	@Id
	@GeneratedValue
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
	public Date getDateFixee() {
		return dateFixee;
	}
	public void setDateFixee(Date dateFixee) {
		this.dateFixee = dateFixee;
	}
	


}
