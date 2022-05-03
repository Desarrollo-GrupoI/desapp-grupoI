package ar.edu.unq.desapp.grupoi.backenddesappapl.dto;

public class UserDTO {
	
	private String nombre;
	private String apellido;
	private Integer operations;
	private String reputation;
	
	public UserDTO(String nombre, String apellido, Integer operations, String reputation) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.operations = operations;
		this.reputation = reputation;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Integer getOperations() {
		return operations;
	}
	public void setOperations(Integer operations) {
		this.operations = operations;
	}
	public String getReputation() {
		return reputation;
	}
	public void setReputation(String reputation) {
		this.reputation = reputation;
	}
	
	

}
