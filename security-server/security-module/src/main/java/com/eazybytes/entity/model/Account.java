package com.eazybytes.entity.model;

import com.eazybytes.entity.DateAudit;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "accounts")
@Setter
@Getter
public class Account extends DateAudit {
	
	@Column(name = "customer_id")
	private Integer customerId;
	
	@Id
	@Column(name = "account_number")
	private Long accountNumber;
	
	@Column(name = "account_type")
	private String accountType;
	
	@Column(name = "branch_address")
	private String branchAddress;
}
