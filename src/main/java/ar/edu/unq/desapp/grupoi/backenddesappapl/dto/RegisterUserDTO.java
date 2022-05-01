package ar.edu.unq.desapp.grupoi.backenddesappapl.dto;

import javax.validation.constraints.*;

public class RegisterUserDTO {
	
	@NotBlank(message = "User must have a name")
    @Size(min = 3, max = 30, message = "User's name must be between 3 and 30 characters")
    private String name;

    @NotBlank(message = "User must have a surname")
    @Size(min = 3, max = 30, message = "User's surname must be between 3 and 30 characters")
    private String surname;

    @NotBlank(message = "User must have an e-mail")
    @Pattern(regexp = "^[a-zA-Z]+[a-zA-Z._-]*@[a-zA-Z]+\\.[a-zA-Z^s]+$", message = "Must be valid email")
    private String email;

    @NotBlank(message = "User must have an address")
    @Size(min = 10, max = 30, message = "User's address must be between 10 and 30 characters")
    private String address;

    @NotBlank(message = "User must have a password")
    @Size(min = 6, message = "Password must contain at least 6 characters")
    @Pattern(regexp = "^(?=.{6,}$)(?=.*[a-z])(?=.*[A-Z])(?=.*\\W).*$", message = "The password must contain at least one uppercase letter, one lowercase letter and one special character")
    private String password;

    @NotBlank(message = "User must have a CVU")
    @Size(min = 22, max = 22, message = "User's CVU must be 22 characters")
    private String cvu;

    @NotBlank(message = "User must have a wallet address")
    @Size(min = 8, max = 8, message = "User's wallet address must be 8 characters")
    private String walletAddress;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCvu() {
        return cvu;
    }

    public void setCvu(String cvu) {
        this.cvu = cvu;
    }

    public String getWalletAddress() {
        return walletAddress;
    }

    public void setWalletAddress(String walletAddress) {
        this.walletAddress = walletAddress;
    }
}
