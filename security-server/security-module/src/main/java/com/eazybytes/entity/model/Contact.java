package com.eazybytes.entity.model;

import com.eazybytes.entity.DateAudit;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "contact_messages")
@Getter
@Setter
public class Contact extends DateAudit {
	
	@Id
	@GenericGenerator(name = "contact_id", strategy = "com.eazybytes.entity.generator.ContactIdGenerator")
	@GeneratedValue(generator = "contact_id")
	@Column(name = "contact_id")
	private String contactId;
	
	@Column(name = "contact_name")
	private String contactName;
	
	@Column(name = "contact_email")
	private String contactEmail;
	
	private String subject;
	
	private String message;
}
