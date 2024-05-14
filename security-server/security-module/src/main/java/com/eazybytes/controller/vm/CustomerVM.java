package com.eazybytes.controller.vm;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerVM {
	
	@JsonProperty("email")
	@NotEmpty(message = "Email should not be null or empty")
	@Email(message = "Email address should be valid")
	private String email;
	
	@JsonProperty("password")
	@NotEmpty(message = "Password should not be null or empty")
	@Size(min = 7, max = 200, message = "Please input a valid password")
	private String pwd;
	
	@JsonProperty("role")
	private String role;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("mobileNumber")
	private String mobileNumber;
}
