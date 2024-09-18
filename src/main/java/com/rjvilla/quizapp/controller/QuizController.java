package com.rjvilla.quizapp.controller;

import com.rjvilla.quizapp.model.QuestionDTO;
import com.rjvilla.quizapp.model.QuizDTO;
import com.rjvilla.quizapp.model.Response;
import com.rjvilla.quizapp.service.Quizservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    Quizservice quizservice;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDTO quizDTO){
        return quizservice.createQuiz(quizDTO);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionDTO>> getQuiz(@PathVariable Integer id){
        return quizservice.getQuizQuestions(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> createQuiz(@PathVariable Integer id, @RequestBody List<Response> responseList){
        return quizservice.calculateResult(id, responseList);
    }


}
