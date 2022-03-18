package com.example.mycoursework2chapter.controllers;

import com.example.mycoursework2chapter.data.Question;
import com.example.mycoursework2chapter.services.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    private QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    public Question add(@RequestParam("question") String question,
                        @RequestParam("answer")String answer) {
        Question addQuestion = questionService.add(question, answer);
        return addQuestion;
    }

    @GetMapping("/remove")
    public Question remove(@RequestParam("question") String question,
                           @RequestParam("answer")String answer) {
        Question removingQuestion = new Question(question, answer);
        questionService.remove(removingQuestion);
        return removingQuestion;
    }

    @GetMapping
    public Collection<Question> getAll() {
        return questionService.getAll();
    }

}
