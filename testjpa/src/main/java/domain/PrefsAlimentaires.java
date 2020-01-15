package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.persistence.*;

@Entity
public class PrefsAlimentaires {

	private long id;
	// !!! JPA ne sait pas  comment traduire List en bdd d'o� * (autre solution
	// : cr�er une classe Allergie et une classe Aliment
	private List<String> aliments = new ArrayList<String>();
	private List<String> allergies = new ArrayList<String>();

	public PrefsAlimentaires() {

	}

	public PrefsAlimentaires(List<String> aliments, List<String> allergies) {
		this.aliments = aliments;
		this.allergies = allergies;
	}

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	//* ce getter ne sera que pour les devs et pas JPA
	@Transient
	public List<String> getAliments() {
		return aliments;
	}
	
	@Transient
	public void setAliments(List<String> aliments) {
		this.aliments = aliments;
	}
	
	//* ces getter/setter sont pour JPA
	protected String getAlimentsBase() {
		// pour mettre la liste en base, on transforme notre liste
		// en chaine du type : "carotte;courgette"
		String res = "";
		for (String s : aliments) {
			res = res + s + ";";
		}
		return res;
	}

	protected void setAlimentsBase(String aliments) {
		//on recoit "carotte;courgette", on re constitue notre liste
		StringTokenizer s = new StringTokenizer(aliments,";");
		this.aliments = new ArrayList<String>();
		while (s.hasMoreElements()) {
			this.aliments .add(s.nextToken());
			
		}
	}

	public void addAliment(String aliment) {
		this.aliments.add(aliment);
	}


	@Transient
	public List<String> getAllergies() {
		return allergies;
	}

	public void setAllergies(List<String> allergies) {
		this.allergies = allergies;
	}


	public void addAllergy(String allergy) {
		this.allergies.add(allergy);
	}
	
	
}
