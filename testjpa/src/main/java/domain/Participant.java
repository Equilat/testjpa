package domain;

import java.util.List;

import javax.persistence.*;

@Entity
public class Participant {

	private String mail;
	private String nom;
	private String prenom;
	private List<Sondage> sondages;
	private List<PrefsAlimentaires> prefsAlimentaires;
	
	// a participant is in only reunion at a time 
	private Reunion reunion;

	// better to put @Id on the getters to preserve encapsulation
	@Id
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@ManyToMany (mappedBy = "participants")
	public List<Sondage> getSondages() {
		return sondages;
	}

	public void setSondages(List<Sondage> sondages) {
		this.sondages = sondages;
	}

	@ManyToOne
	public Reunion getReunion() {
		return reunion;
	}

	public void setReunion(Reunion reunion) {
		this.reunion = reunion;
	}

	@OneToMany
	@JoinColumn(name = "Id")
	public List<PrefsAlimentaires> getPrefsAlimentaires() {
		return this.prefsAlimentaires;
	}

	public void setPrefsAlimentaires(List<PrefsAlimentaires> prefsAlimentaires) {
		this.prefsAlimentaires = prefsAlimentaires;
	}
}
