package com.example.mycoursework2chapter.services.impl;

import com.example.mycoursework2chapter.data.Question;
import com.example.mycoursework2chapter.exceptions.QuestionAlreadyExistsException;
import com.example.mycoursework2chapter.exceptions.QuestionDoNotExistException;
import com.example.mycoursework2chapter.services.QuestionService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
@Service
public class JavaQuestionService implements QuestionService {

    Set<Question> questions = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        Question addingQuestion = new Question(question, answer);
        checkQuestion(addingQuestion);
        if (questions.contains(addingQuestion)) {
            throw new QuestionAlreadyExistsException("The question exists in the list");
        }
        questions.add(addingQuestion);
        return addingQuestion;
    }

    @Override
    public Question add(Question question) {
        checkQuestion(question);
        if (questions.contains(question)) {
            throw new QuestionAlreadyExistsException("The question exists in the list");
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        checkQuestion(question);
        if (!questions.contains(question)) {
            throw new QuestionDoNotExistException("Question does not found in the list");
        }
        questions.remove(question);
        return question;
    }

    private void checkQuestion(Question question) {
        if (question == null || question.getQuestion() == null || question.getAnswer() == null) {
            throw new NullPointerException("Enter correct question");
        }
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int i = random.nextInt(questions.size());
        return questions.stream().
               toList().get(i);
    }
}
