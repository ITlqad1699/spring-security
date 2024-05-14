package com.eazybytes.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * The type Cards dto.
 */
@Data
public class CardsDTO {
    @JsonProperty("cardId")
    private Integer cardId;

    @JsonProperty("customerId")
    private Integer customerId;

    @JsonProperty("cardNumber")
    private String cardNumber;

    @JsonProperty("cardType")
    private String cardType;

    @JsonProperty("totalLimit")
    private Integer totalLimit;

    @JsonProperty("amountUsed")
    private Integer amountUsed;

    @JsonProperty("availableAmount")
    private Integer availableAmount;
}
