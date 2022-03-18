package com.example.mycoursework2chapter.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TheAmountOfQuestionsException extends RuntimeException {
    public TheAmountOfQuestionsException(String message) {
        super(message);
    }
}
