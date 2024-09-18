package com.rjvilla.quizapp.service;

import com.rjvilla.quizapp.dao.QuestionDao;
import com.rjvilla.quizapp.dao.QuizDao;
import com.rjvilla.quizapp.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class Quizservice {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(QuizDTO quizDTO){

        List<Question> questions = questionDao.findRandomQuestionsByCategory(quizDTO.getCategory(), quizDTO.getNumQ());

        Quiz quiz = new Quiz();
        quiz.setTitle(quizDTO.getTitle());
        quiz.setQuestions(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("success", HttpStatus.CREATED);


    }

    public ResponseEntity<List<QuestionDTO>> getQuizQuestions(Integer id) {
       Optional<Quiz> quiz = quizDao.findById(id);
       if(quiz.isEmpty()){
           return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NOT_FOUND);
       }

       List<Question> questionsFromDb = quiz.get().getQuestions();
       List<QuestionDTO> questionsForUser = new ArrayList<>();

       for(Question currentQuestion:questionsFromDb){
           questionsForUser.add(new QuestionDTO(currentQuestion));
       }

       return new ResponseEntity<>(questionsForUser,HttpStatus.OK);

    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responseList) {

        Optional<Quiz> quiz = quizDao.findById(id);
        if(quiz.isEmpty()){
            return new ResponseEntity<>(0, HttpStatus.NOT_FOUND);
        }
        List<Question> questionList = quiz.get().getQuestions();
        int right = 0;
        int i = 0;
        for(Response response: responseList){
            if(response.getResponse().equals(questionList.get(i).getRightAnswer())){
                right++;
            }
            i++;
        }
        return new ResponseEntity<>(right,HttpStatus.OK);
    }
}
