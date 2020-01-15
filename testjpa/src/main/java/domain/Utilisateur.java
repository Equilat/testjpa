package domain;

import java.util.List;

import javax.persistence.*;

@Entity
public class Utilisateur {

	private String mail;
	private String nom;
	private String prenom;
	private List<Sondage> sondages;
	private PrefsAlimentaires prefsAlimentaires;

	public Utilisateur() {
	}

	public Utilisateur(String mail, String nom, String prenom) {
		this.mail = mail;
		this.nom = nom;
		this.prenom = prenom;
	}

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

	@ManyToMany (mappedBy = "utilisateurs")
	public List<Sondage> getSondages() {
		return sondages;
	}

	public void setSondages(List<Sondage> sondages) {
		this.sondages = sondages;
	}

	@OneToOne
	public PrefsAlimentaires getPrefsAlimentaires() {
		return this.prefsAlimentaires;
	}

	public void setPrefsAlimentaires(PrefsAlimentaires prefsAlimentaires) {
		this.prefsAlimentaires = prefsAlimentaires;
	}
}
