package com.rjvilla.quizapp.model;

import com.fasterxml.jackson.annotation.JacksonAnnotation;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

@Data
public class QuizDTO {

    private String category;

    @JsonProperty("numberOfQuestions")
    private Integer numQ;
    private String title;

}
