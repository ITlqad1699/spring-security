package com.eazybytes.controller;

import com.eazybytes.dto.NoticeDTO;
import com.eazybytes.service.NoticeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * The type Notices controller.
 */
@RestController
@AllArgsConstructor
@Slf4j
public class NoticesController {

    /**
     * The Notice service.
     */
    NoticeService noticeService;

    /**
     * Gets notices.
     *
     * @return the notices
     */
    @GetMapping("/v1/notices")
    public ResponseEntity<List<NoticeDTO>> getNotices() {

        List<NoticeDTO> notices = noticeService.findAllActiveNotices();
        if (notices.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok()
                .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                .body(notices);

    }

}
