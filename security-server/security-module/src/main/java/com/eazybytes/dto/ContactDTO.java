package com.eazybytes.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * The type Contact dto.
 */
@Data
public class ContactDTO {
	
	@JsonProperty("contactId")
	private String contactId;
	
	@JsonProperty("contactName")
	private String contactName;
	
	@JsonProperty("contactEmail")
	private String contactEmail;
	
	@JsonProperty("subject")
	private String subject;
	
	@JsonProperty("message")
	private String message;
}
