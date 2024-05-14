package com.eazybytes.service;

import com.eazybytes.dto.NoticeDTO;

import java.util.List;

public interface NoticeService {
    List<NoticeDTO> findAllActiveNotices();
}
