package com.eazybytes.entity.model;

import com.eazybytes.entity.DateAudit;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@Entity
@Table(name = "notice_details")
@Getter
@Setter
public class Notice extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "notice_id")
    private Long noticeId;

    @Column(name = "notice_summary")
    private String noticeSummary;

    @Column(name = "notice_details")
    private String noticeDetails;

    @Column(name = "notice_beg_dt")
    private Date noticeBegDt;

    @Column(name = "notice_end_dt")
    private Date noticeEndDt;
}
