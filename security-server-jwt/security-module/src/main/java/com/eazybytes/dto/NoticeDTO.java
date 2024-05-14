package com.eazybytes.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class NoticeDTO {
    @JsonProperty("noticeId")
    private Long noticeId;
    @JsonProperty("noticeSummary")
    private String noticeSummary;
    @JsonProperty("noticeDetails")
    private String noticeDetails;
    @JsonProperty("noticeBegDt")
    private Date noticeBegDt;
    @JsonProperty("noticeEndDt")
    private Date noticeEndDt;
    @JsonProperty("createDt")
    private Date createDt;
    @JsonProperty("updateDt")
    private Date updateDt;
}
