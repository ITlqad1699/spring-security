package com.eazybytes.controller.vm;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ContactVM {

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
