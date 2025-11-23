package com.angel.services;

import java.util.List;

import com.angel.entities.Notice;

public interface NoticeService {
    List<Notice> getAllNotices();
    Notice getNoticeById(Long id);
    Notice createNotice(Notice notice);
    Notice updateNotice(Long id, Notice notice);
    void deleteNotice(Long id);
    List<Notice> getAllActiveNotices();
    List<Notice> getAllNoticesSortedByTitle();
    List<Notice> getAllNoticesSortedByCreateDateAsc();
    List<Notice> getAllNoticesSortedByCreateDateDesc();
}
