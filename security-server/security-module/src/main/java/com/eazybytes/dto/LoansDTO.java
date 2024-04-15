package com.eazybytes.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class LoansDTO {

    @JsonProperty("loanNumber")
    private Integer loanNumber;

    @JsonProperty("customerId")
    private Integer customerId;

    @JsonProperty("startDt")
    private Date startDt;

    @JsonProperty("loanType")
    private String loanType;

    @JsonProperty("totalLoan")
    private Integer totalLoan;

    @JsonProperty("amountPaid")
    private Integer amountPaid;

    @JsonProperty("outstandingAmount")
    private Integer outstandingAmount;
}
