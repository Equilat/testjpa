package domain;

import java.util.List;

import javax.persistence.*;

@Entity
public class Sondage {
	
	private long id;
	
	private String lienWeb;
	private List<Date> dates;
	private List<Utilisateur> utilisateurs;
	private Reunion reunion;

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
	@JoinColumn(name = "id")
	public List<Date> getDates() {
		return dates;
	}

	public void setDates(List<Date> dates) {
		this.dates = dates;
	}

	@ManyToMany
	@JoinTable(name = "UTILISATEUR_SONDAGE")
	public List<Utilisateur> getUtilisateurs() {
		return this.utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	@OneToOne
	public Reunion getReunion() {
		return this.reunion;
	}

	public void setReunion(Reunion reunion) {
		this.reunion = reunion;
	}
	

}
