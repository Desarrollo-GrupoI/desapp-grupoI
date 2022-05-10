package ar.edu.unq.desapp.grupoi.backenddesappapl.dto;

public class UserDTO {
	private String name;
	private String surname;
	private Integer operations;
	private String reputation;
	
	public UserDTO(String name, String surname, Integer operations, String reputation) {
		this.name = name;
		this.surname = surname;
		this.operations = operations;
		this.reputation = reputation;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return this.surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public Integer getOperations() {
		return this.operations;
	}
	
	public void setOperations(Integer operations) {
		this.operations = operations;
	}
	
	public String getReputation() {
		return this.reputation;
	}
	
	public void setReputation(String reputation) {
		this.reputation = reputation;
	}
}
