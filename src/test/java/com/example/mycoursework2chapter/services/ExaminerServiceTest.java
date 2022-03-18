package com.example.mycoursework2chapter.services;


import com.example.mycoursework2chapter.exceptions.TheAmountOfQuestionsException;
import com.example.mycoursework2chapter.exceptions.TheEmptyListOfQuestionsException;
import com.example.mycoursework2chapter.services.impl.ExaminerServiceImpl;
import com.example.mycoursework2chapter.services.impl.JavaQuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.HashSet;

import static com.example.mycoursework2chapter.services.ServiceConstants.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceTest {

    @Mock
    private JavaQuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl out;


    @Test
    public void shouldReturnAllQuestions() {
        when(questionService.getAll()).thenReturn(QUESTIONS_1);
        when(questionService.getRandomQuestion()).thenReturn(QUESTION_ONE);
        assertEquals(questionService.getAll(),out.getQuestions(1));
    }

    @Test
    public void shouldReturnThrowWhenQuestionsAreLessThenAmount() {
        when(questionService.getAll()).thenReturn(new ArrayList<>());
        assertThrows(TheAmountOfQuestionsException.class, () -> out.getQuestions(1));
    }

    @Test
    public void shouldReturnThrowWhenQuestionListIsEmpty() {
        when(questionService.getAll()).thenReturn(new HashSet<>());
        assertThrows(TheEmptyListOfQuestionsException.class, () -> out.getQuestions(0));
    }


}
