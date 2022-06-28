package ar.edu.unq.desapp.grupoi.backenddesappapl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserCredentialsDTO {
	
	@JsonProperty
    private String email;

    @JsonProperty
    private String password;

    public String email() {
        return email;
    }

    public String password() {
        return password;
    }

}
