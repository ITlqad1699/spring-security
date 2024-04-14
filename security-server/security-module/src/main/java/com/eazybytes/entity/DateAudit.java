package com.eazybytes.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.sql.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Setter
@Getter
public abstract class DateAudit implements Serializable {
    @CreatedDate
    @Column(name = "create_dt", nullable = false, updatable = false)
    private Date createDt;

    @LastModifiedDate
    @Column(name = "update_dt")
    private Date updateDt;

}