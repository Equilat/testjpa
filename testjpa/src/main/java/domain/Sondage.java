package domain;

import java.util.List;

import javax.persistence.*;

@Entity
public class Sondage {
	
	private long id;
	
	private String lienWeb;
	private List<DateReu> dateReus;
	private List<Utilisateur> utilisateurs;
	private Reunion reunion;

	public Sondage() {

	}

	public Sondage(String lienWeb, Reunion reunion) {
		this.lienWeb = lienWeb;
		this.reunion = reunion;
	}

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
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
	public List<DateReu> getDateReus() {
		return dateReus;
	}

	public void setDateReus(List<DateReu> dateReus) {
		this.dateReus = dateReus;
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

	public void addUtilisateur(Utilisateur utilisateur) {
		this.utilisateurs.add(utilisateur);
	}

}
