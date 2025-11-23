package com.angel.controller;

import com.angel.entities.Notice;
import com.angel.services.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequiredArgsConstructor
public class NoticesController {

    private final NoticeService noticeService;

    @GetMapping("/notices")
    public ResponseEntity<List<Notice>> getNotices() {
        List<Notice> notices = noticeService.getAllActiveNotices();
        if (notices != null) {
            return ResponseEntity.ok()
                    .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                    .body(notices);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/notices/{id}")
    public ResponseEntity<Notice> getNoticeById(@PathVariable Long id) {
        Notice notice = noticeService.getNoticeById(id);
        return ResponseEntity.ok(notice);
    }

    @PostMapping("/notices")
    public ResponseEntity<Notice> createNotice(@RequestBody Notice notice) {
        Notice createdNotice = noticeService.createNotice(notice);
        return ResponseEntity.ok(createdNotice);
    }

    @PutMapping("/notices/{id}")
    public ResponseEntity<Notice> updateNotice(@PathVariable Long id, @RequestBody Notice notice) {
        Notice updatedNotice = noticeService.updateNotice(id, notice);
        return ResponseEntity.ok(updatedNotice);
    }

    @DeleteMapping("/notices/{id}")
    public ResponseEntity<Void> deleteNotice(@PathVariable Long id) {
        noticeService.deleteNotice(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/notices/sorted")
    public ResponseEntity<List<Notice>> getNoticesSortedByTitle() {
        List<Notice> notices = noticeService.getAllNoticesSortedByTitle();
        return ResponseEntity.ok(notices);
    }

    @GetMapping("/notices/sortedByCreateDateAsc")
    public ResponseEntity<List<Notice>> getNoticesSortedByCreateDateAsc() {
        List<Notice> notices = noticeService.getAllNoticesSortedByCreateDateAsc();
        return ResponseEntity.ok(notices);
    }

    @GetMapping("/notices/sortedByCreateDateDesc")
    public ResponseEntity<List<Notice>> getNoticesSortedByCreateDateDesc() {
        List<Notice> notices = noticeService.getAllNoticesSortedByCreateDateDesc();
        return ResponseEntity.ok(notices);
    }
}
