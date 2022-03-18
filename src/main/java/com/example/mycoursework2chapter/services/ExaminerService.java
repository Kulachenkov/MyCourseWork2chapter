package com.example.mycoursework2chapter.services;

import com.example.mycoursework2chapter.data.Question;
import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
