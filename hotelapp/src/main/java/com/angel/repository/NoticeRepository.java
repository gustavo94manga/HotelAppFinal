package com.angel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.angel.entities.Notice;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {
    
    @Query("from Notice n where CURDATE() BETWEEN n.noticBegDt AND n.noticEndDt")
    List<Notice> findAllActiveNotices();

    // Additional method for sorting notices by title
    List<Notice> findAllByOrderByNoticeSummaryAsc();
    
 // Method to sort by creation date in ascending order
    List<Notice> findAllByOrderByCreateDtAsc();

    // Method to sort by creation date in descending order
    List<Notice> findAllByOrderByCreateDtDesc();
}
