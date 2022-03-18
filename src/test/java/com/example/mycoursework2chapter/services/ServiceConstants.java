package com.example.mycoursework2chapter.services;

import com.example.mycoursework2chapter.data.Question;
import java.util.Collection;
import java.util.Set;

public class ServiceConstants {

    public static final String FIRST_QUESTION = "question one";
    public static final String SECOND_QUESTION = "question two";
    public static final String THIRD_QUESTION = "question three";

    public static final String FIRST_ANSWER = "answer one";
    public static final String SECOND_ANSWER = "answer two";
    public static final String THIRD_ANSWER = "answer three";

    public static final Question QUESTION_ONE = new Question(FIRST_QUESTION, FIRST_ANSWER);
    public static final Question QUESTION_TWO = new Question(SECOND_QUESTION, SECOND_ANSWER);
    public static final Question QUESTION_THREE = new Question(THIRD_QUESTION, THIRD_ANSWER);

    public static final Set<Question> QUESTIONS = Set.of(QUESTION_ONE, QUESTION_TWO, QUESTION_THREE);
    public static final Collection<Question> QUESTIONS_1 = Set.of(QUESTION_ONE);



}
