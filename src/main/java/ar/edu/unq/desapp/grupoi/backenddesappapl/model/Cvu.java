package ar.edu.unq.desapp.grupoi.backenddesappapl.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Cvu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer number;
	
	public Cvu() {}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
}
