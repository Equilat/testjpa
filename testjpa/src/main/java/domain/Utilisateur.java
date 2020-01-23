package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

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
		sondages = new ArrayList<>();
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

	@ManyToMany (mappedBy = "utilisateurs", cascade = CascadeType.MERGE)
	public List<Sondage> getSondages() {
		return sondages;
	}

	public void setSondages(List<Sondage> sondages) {
		this.sondages = sondages;
	}

	public Utilisateur addSondages(List<Sondage> sondages) {
		for(Sondage sondage : sondages) {
			sondage.getUtilisateurs().add(this);
			this.getSondages().add(sondage);
		}
		return this;
	}

	@OneToOne
	public PrefsAlimentaires getPrefsAlimentaires() {
		return this.prefsAlimentaires;
	}

	public void setPrefsAlimentaires(PrefsAlimentaires prefsAlimentaires) {
		this.prefsAlimentaires = prefsAlimentaires;
	}
}
