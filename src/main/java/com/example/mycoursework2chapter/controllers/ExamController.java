package com.example.mycoursework2chapter.controllers;

import com.example.mycoursework2chapter.data.Question;
import com.example.mycoursework2chapter.services.ExaminerService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/exam/get")
public class ExamController {
    ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping(path = "/{amount}")
    public Collection<Question> getQuestions(@PathVariable("amount") int amount) {
        return examinerService.getQuestions(amount);
    }


}
