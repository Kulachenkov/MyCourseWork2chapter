package com.example.mycoursework2chapter.services.impl;

import com.example.mycoursework2chapter.data.Question;
import com.example.mycoursework2chapter.exceptions.TheAmountOfQuestionsException;
import com.example.mycoursework2chapter.exceptions.TheEmptyListOfQuestionsException;
import com.example.mycoursework2chapter.services.ExaminerService;
import com.example.mycoursework2chapter.services.QuestionService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Collection<Question> randomQuestionsList = new HashSet<>();
        if (amount > questionService.getAll().size()) {
            throw new TheAmountOfQuestionsException("Enter another amount of questions");
        }
        if (questionService.getAll().isEmpty()) {
            throw new TheEmptyListOfQuestionsException("Add questions to the list");
        }
        while (randomQuestionsList.size() != amount) {
            randomQuestionsList.add(questionService.getRandomQuestion());
        }
        return randomQuestionsList;
    }
}
