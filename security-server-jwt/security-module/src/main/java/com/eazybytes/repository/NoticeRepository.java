package com.eazybytes.repository;

import com.eazybytes.entity.model.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {
    @Query(value = "select n from Notice n where CURDATE() BETWEEN n.noticeBegDt AND n.noticeEndDt")
    List<Notice> findAllActiveNotices();
}
