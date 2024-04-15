package com.eazybytes.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * The type Account dto.
 */
@Data
public class AccountDTO {
    @JsonProperty("customerId")
    private Integer customerId;
    @JsonProperty("accountNumber")
    private Long accountNumber;
    @JsonProperty("accountType")
    private String accountType;
    @JsonProperty("branchAddress")
    private String branchAddress;
}
