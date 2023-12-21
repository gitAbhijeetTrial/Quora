package com.example.quoraproject.service;

import com.example.quoraproject.dto.QuestionCreationDTO;
import com.example.quoraproject.model.Question;

public interface QuestionService {
    Question createQuestion(QuestionCreationDTO request);

    Question getQuestionById(Long id);

    Question updateQuestion(Long id, Question question);

    boolean deleteQuestion(Long id);
}
