package ar.edu.unq.desapp.grupoi.backenddesappapl.dto;

import javax.validation.constraints.*;

public class RegisterUserDTO {
	@NotBlank(message = "User must have a name")
    @Size(min = 3, max = 30, message = "User name must be between 3 and 30 characters")
    private String name;

    @NotBlank(message = "User must have a surname")
    @Size(min = 3, max = 30, message = "User surname must be between 3 and 30 characters")
    private String surname;

    @NotBlank(message = "User must have an e-mail")
    @Pattern(regexp = "^[a-zA-Z]+[a-zA-Z._-]*@[a-zA-Z]+\\.[a-zA-Z^s]+$", message = "Must be valid email")
    private String email;

    @NotBlank(message = "User must have an address")
    @Size(min = 10, max = 30, message = "User address must be between 10 and 30 characters")
    private String address;

    @NotBlank(message = "User must have a password")
    @Size(min = 6, message = "Password must contain at least 6 characters")
    @Pattern(regexp = "^(?=.{6,}$)(?=.*[a-z])(?=.*[A-Z])(?=.*\\W).*$", message = "The password must contain at least one uppercase letter, one lowercase letter and one special character")
    private String password;
 
    public RegisterUserDTO(String name, String surname, String email, String address, String password) {		
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.address = address;
		this.password = password;
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

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
