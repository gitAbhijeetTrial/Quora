package com.example.quoraproject.service;

import com.example.quoraproject.dto.ContentDTO;
import com.example.quoraproject.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContestServiceImpl implements ContentService{

    @Autowired
    ContentRepository contentRepository;
    @Override
    public Page<ContentDTO> getContentByUserAndTopics(Long userId, Pageable pageable) {
        return contentRepository.findContentByUserAndTopics(userId, pageable);
    }
}
