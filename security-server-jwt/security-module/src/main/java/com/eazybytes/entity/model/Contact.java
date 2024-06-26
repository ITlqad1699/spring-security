package com.eazybytes.entity.model;

import com.eazybytes.entity.BaseAuditEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "contact_messages")
@Getter
@Setter
public class Contact extends BaseAuditEntity {
    @Id
    @Column(name = "contact_id")
//    @GenericGenerator(name = "contact_id", strategy = "com.eazybytes.entity.generator.ContactIdGenerator")
//    @GeneratedValue(generator = "contact_id")
    private String contactId;

    @Column(name = "contact_name")
    private String contactName;

    @Column(name = "contact_email")
    private String contactEmail;

    private String subject;

    private String message;
}
