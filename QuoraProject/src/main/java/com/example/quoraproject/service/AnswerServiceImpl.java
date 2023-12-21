package com.example.quoraproject.service;

import com.example.quoraproject.dto.AnswerCreationDTO;
import com.example.quoraproject.model.Answer;
import com.example.quoraproject.model.Question;
import com.example.quoraproject.model.User;
import com.example.quoraproject.repository.AnswerRepository;
import com.example.quoraproject.repository.QuestionRepository;
import com.example.quoraproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    AnswerRepository answerRepository;

    @Override
    public Answer createAnswer(AnswerCreationDTO request, Long questionId) {

        Answer newAnswer = new Answer();
        newAnswer.setContent(request.getContent());
        User user = userRepository.findById(request.getUserId()).orElse(null);
        Question question = questionRepository.findById(questionId).orElse(null);
        if (user != null && question != null) {
            newAnswer.setAuthor(user);
            newAnswer.setQuestion(question);
            answerRepository.save(newAnswer);
            return newAnswer;
        }
        return null;
    }

    @Override
    public List<Answer> getAnswersForQuestion(Long questionId) {
        return answerRepository.findByQuestionId(questionId);
    }

    @Override
    public Answer updateAnswer(Long id, Answer updatedAnswer) {
        Answer existingAnswer = answerRepository.findById(id).orElse(null);
        if (existingAnswer != null) {
            existingAnswer.setContent(updatedAnswer.getContent());
            return answerRepository.save(existingAnswer);
        }
        return null;
    }

    @Override
    public boolean deleteAnswer(Long id) {
        if (answerRepository.existsById(id)) {
            answerRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
