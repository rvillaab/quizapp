package com.rjvilla.quizapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class QuizDTO {

    private String category;

    @JsonProperty("numberOfQuestions")
    private Integer numQ;
    private String title;

}
