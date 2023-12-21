package com.example.quoraproject.service;

import com.example.quoraproject.dto.AnswerCreationDTO;
import com.example.quoraproject.model.Answer;

import java.util.List;

public interface AnswerService {

    Answer createAnswer(AnswerCreationDTO request, Long questionId);

    List<Answer> getAnswersForQuestion(Long questionId);

    Answer updateAnswer(Long id, Answer updatedAnswer);

    boolean deleteAnswer(Long id);
}
