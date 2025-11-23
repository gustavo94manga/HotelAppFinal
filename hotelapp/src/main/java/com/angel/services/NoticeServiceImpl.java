package com.angel.services;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.angel.entities.Notice;
import com.angel.exceptionhandling.ResourceNotFoundException;
import com.angel.repository.NoticeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {
	
	private final NoticeRepository noticeRepository;

    @Override
    public List<Notice> getAllNotices() {
        return noticeRepository.findAll();
    }

    @Override
    public Notice getNoticeById(Long id) {
        return noticeRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Notice not found with id: " + id));
    }

    @Override
    public Notice createNotice(Notice notice) {
        notice.setCreateDt(new Date(System.currentTimeMillis()));
        notice.setUpdateDt(new Date(System.currentTimeMillis()));
        return noticeRepository.save(notice);
    }

    @Override
    public Notice updateNotice(Long id, Notice notice) {
        Notice existingNotice = noticeRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Notice not found"));
        
        existingNotice.setNoticeSummary(notice.getNoticeSummary());
        existingNotice.setNoticeDetails(notice.getNoticeDetails());
        existingNotice.setNoticBegDt(notice.getNoticBegDt());
        existingNotice.setNoticEndDt(notice.getNoticEndDt());
        existingNotice.setUpdateDt(new Date(System.currentTimeMillis()));

        return noticeRepository.save(existingNotice);
    }

    @Override
    public void deleteNotice(Long id) {
        noticeRepository.deleteById(id);
    }

    @Override
    public List<Notice> getAllActiveNotices() {
        return noticeRepository.findAllActiveNotices();
    }

    @Override
    public List<Notice> getAllNoticesSortedByTitle() {
        return noticeRepository.findAllByOrderByNoticeSummaryAsc();
    }

    @Override
    public List<Notice> getAllNoticesSortedByCreateDateAsc() {
        return noticeRepository.findAllByOrderByCreateDtAsc();
    }

    @Override
    public List<Notice> getAllNoticesSortedByCreateDateDesc() {
        return noticeRepository.findAllByOrderByCreateDtDesc();
    }

}