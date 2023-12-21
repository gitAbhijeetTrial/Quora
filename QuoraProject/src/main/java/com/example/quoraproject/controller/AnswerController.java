package com.example.quoraproject.controller;


import com.example.quoraproject.dto.AnswerCreationDTO;
import com.example.quoraproject.model.Answer;
import com.example.quoraproject.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/answers")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @PostMapping("/create")
    public ResponseEntity<String> createAnswer(@RequestBody AnswerCreationDTO request,@PathVariable Long questionId) {
        Answer newAnswer = answerService.createAnswer(request,questionId);
        if (newAnswer != null) {
            return ResponseEntity.ok("Answer created successfully");
        } else {
            return ResponseEntity.badRequest().body("Answer creation failed");
        }
    }

    @GetMapping
    public ResponseEntity<List<Answer>> getAnswersForQuestion(@PathVariable Long questionId) {
        List<Answer> answers = answerService.getAnswersForQuestion(questionId);
        if(answers.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(answers);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Answer> updateAnswer(@PathVariable Long id, @RequestBody Answer answer) {
        Answer updatedAnswer = answerService.updateAnswer(id, answer);
        if (updatedAnswer != null) {
            return ResponseEntity.ok(updatedAnswer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnswer(@PathVariable Long id) {
        boolean deleted = answerService.deleteAnswer(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
