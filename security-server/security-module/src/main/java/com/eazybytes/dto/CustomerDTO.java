package com.eazybytes.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CustomerDTO {
	@JsonProperty("id")
	private Integer id;
	@JsonProperty("email")
	private String email;
	@JsonProperty("pwd")
	private String pwd;
	@JsonProperty("role")
	private String role;
	@JsonProperty("name")
	private String name;
	@JsonProperty("mobileNumber")
	private String mobileNumber;
}
