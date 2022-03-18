package com.example.mycoursework2chapter.exceptions;

public class QuestionAlreadyExistsException extends RuntimeException {
    public QuestionAlreadyExistsException(String message) {
        super(message);
    }
}
