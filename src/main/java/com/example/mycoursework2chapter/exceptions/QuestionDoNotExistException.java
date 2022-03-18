package com.example.mycoursework2chapter.exceptions;

public class QuestionDoNotExistException extends RuntimeException {
    public QuestionDoNotExistException(String message) {
        super(message);
    }
}
