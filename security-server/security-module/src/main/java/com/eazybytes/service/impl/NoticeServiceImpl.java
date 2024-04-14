package com.eazybytes.service.impl;

import com.eazybytes.dto.NoticeDTO;
import com.eazybytes.entity.model.Notice;
import com.eazybytes.repository.NoticeRepository;
import com.eazybytes.service.NoticeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * The type Notice service.
 */
@Service
@AllArgsConstructor
public class NoticeServiceImpl implements NoticeService {

    /**
     * The Model mapper.
     */
    ModelMapper modelMapper;

    /**
     * The Notice repository.
     */
    NoticeRepository noticeRepository;

    @Override
    public List<NoticeDTO> findAllActiveNotices() {
        List<Notice> notices = noticeRepository.findAllActiveNotices();
        if (notices.isEmpty()) {
            return Collections.emptyList();
        }
        return notices.stream().map(notice -> modelMapper.map(notice, NoticeDTO.class)).toList();
    }
}
