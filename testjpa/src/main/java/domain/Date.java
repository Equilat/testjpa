package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Date {

	private long id;
	private boolean pause;
	private List<Reunion> reunions;
	
	@Id
	@GeneratedValue
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

	@OneToMany (mappedBy = "dateFixee")
	public List<Reunion> getReunions() {
		return this.reunions;
	}

	public void setReunions(List<Reunion> reunions) {
		this.reunions = reunions;
	}

}
