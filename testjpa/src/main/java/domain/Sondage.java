package domain;

import java.util.List;

import javax.persistence.*;

@Entity
public class Sondage {
	
	private long id;
	
	private String lienWeb;
	private List<Date> dates;
	private List<Participant> participants;

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLienWeb() {
		return lienWeb;
	}

	public void setLienWeb(String lienWeb) {
		this.lienWeb = lienWeb;
	}
	
	@OneToMany
	@JoinColumn(name = "Id")
	public List<Date> getDates() {
		return dates;
	}

	public void setDates(List<Date> dates) {
		this.dates = dates;
	}

	@ManyToMany
	@JoinTable(name = "PARTICIPANT_SONDAGE")
	public List<Participant> getParticipants() {
		return this.participants;
	}

	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}
	

}
