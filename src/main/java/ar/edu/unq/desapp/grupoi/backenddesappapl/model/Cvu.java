package ar.edu.unq.desapp.grupoi.backenddesappapl.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cvu")
public class Cvu {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cvu;
	
	public Cvu() {}

	public Cvu(Integer cvu) {
		this.cvu = cvu;
	}

	public Integer getCvu() {
		return cvu;
	}

	public void setCvu(Integer cvu) {
		this.cvu = cvu;
	}
}
