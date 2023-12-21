package com.example.quoraproject.service;

import com.example.quoraproject.dto.ContentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContentService {

    Page<ContentDTO> getContentByUserAndTopics(Long userId, Pageable pageable);
}
