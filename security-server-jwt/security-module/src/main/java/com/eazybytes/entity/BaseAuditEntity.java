package com.eazybytes.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public abstract class BaseAuditEntity implements Serializable {
    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "create_dt", nullable = false, updatable = false)
    private Date createDt;

    @LastModifiedDate
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "update_dt")
    private Date updateDt;

//
//    @Column(name = "created_by", nullable = false, updatable = false)
//    @CreatedBy
//    protected String createdBy;
//
//    @Column(name = "modified_by", insertable = false)
//    @LastModifiedBy
//    protected String modifiedBy;

}