package com.eazybytes.dto;

import lombok.Data;

/**
 * The type Contact dto.
 */
@Data
public class ContactDTO {

    private String contactId;

    private String contactName;

    private String contactEmail;

    private String subject;

    private String message;
}
