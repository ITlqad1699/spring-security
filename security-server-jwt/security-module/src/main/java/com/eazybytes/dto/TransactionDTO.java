package com.eazybytes.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.sql.Date;

@Data
public class TransactionDTO {
    @JsonProperty("transactionId")
    private String transactionId;

    @JsonProperty("accountNumber")
    private Long accountNumber;

    @JsonProperty("customerId")
    private Integer customerId;

    @JsonProperty("transactionDt")
    private Date transactionDt;

    @JsonProperty("transactionSummary")
    private String transactionSummary;

    @JsonProperty("transactionType")
    private String transactionType;

    @JsonProperty("transactionAmt")
    private Integer transactionAmt;

    @JsonProperty("closingBalance")
    private Integer closingBalance;
}
