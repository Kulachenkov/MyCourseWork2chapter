package com.example.mycoursework2chapter.services;

import com.example.mycoursework2chapter.data.Question;
import com.example.mycoursework2chapter.exceptions.QuestionAlreadyExistsException;
import com.example.mycoursework2chapter.exceptions.QuestionDoNotExistException;
import com.example.mycoursework2chapter.services.impl.JavaQuestionService;
import org.junit.jupiter.api.Test;
import java.util.Collection;

import static com.example.mycoursework2chapter.services.ServiceConstants.*;
import static org.junit.jupiter.api.Assertions.*;

public class JavaQuestionServiceTest {

    private final JavaQuestionService out = new JavaQuestionService();

    @Test
    public void shouldAddQuestionUsingQA() {
        Question expectedQuestion = new Question(FIRST_QUESTION, FIRST_ANSWER);
        assertEquals(0,out.getAll().size());
        assertEquals(expectedQuestion,out.add(FIRST_QUESTION, FIRST_ANSWER));
        assertEquals(1,out.getAll().size());
        assertTrue(out.getAll().contains(expectedQuestion));
    }

    @Test
    public void shouldReturnThrowWhenQuestionOrAnswerAreNull() {
        assertEquals(0,out.getAll().size());
        assertThrows(NullPointerException.class, () -> out.add(null, null));
        assertThrows(NullPointerException.class, () -> out.add(FIRST_QUESTION, null));
        assertThrows(NullPointerException.class, () -> out.add(null, FIRST_ANSWER));
        assertThrows(NullPointerException.class, () -> out.add(null));
    }

    @Test
    public void shouldAddQuestion() {
        Question expectedQuestion = new Question(FIRST_QUESTION, FIRST_ANSWER);
        assertEquals(0,out.getAll().size());
        assertEquals(expectedQuestion,out.add(QUESTION_ONE));
        assertEquals(1,out.getAll().size());
        assertTrue(out.getAll().contains(expectedQuestion));
    }

    @Test
    public void shouldReturnThrowWhenQuestionExists() {
        Question expectedQuestion = new Question(FIRST_QUESTION, FIRST_ANSWER);
        out.add(expectedQuestion);
        assertEquals(1,out.getAll().size());
        assertTrue(out.getAll().contains(expectedQuestion));
        assertThrows(QuestionAlreadyExistsException.class, () -> out.add(expectedQuestion));
    }

    @Test
    public void shouldRemoveQuestion() {
        Question expectedQuestion = new Question(FIRST_QUESTION, FIRST_ANSWER);
        out.add(expectedQuestion);
        assertEquals(1,out.getAll().size());
        assertTrue(out.getAll().contains(expectedQuestion));
        assertEquals(expectedQuestion,out.remove(QUESTION_ONE));
        assertEquals(0,out.getAll().size());
        assertTrue(!out.getAll().contains(expectedQuestion));
    }

    @Test
    public void shouldReturnThrowWhenRemoveQuestion() {
        assertEquals(0,out.getAll().size());
        assertThrows(QuestionDoNotExistException.class, () -> out.remove(QUESTION_ONE));
    }

    @Test
    public void shouldReturnThrowWhenQuestionIsNull() {
        assertThrows(NullPointerException.class, () -> out.remove(null));
    }

    @Test
    public void shouldReturnEmptyList() {
        assertTrue(out.getAll().isEmpty());
    }

    @Test
    public void shouldReturnList() {
        out.add(QUESTION_ONE);
        out.add(QUESTION_TWO);
        out.add(QUESTION_THREE);
        Collection<Question> expectedCollection = QUESTIONS;
        assertEquals(expectedCollection, out.getAll());
    }

    @Test
    public void shouldReturnRandomQuestion() {
        out.add(QUESTION_ONE);
        assertEquals(QUESTION_ONE,out.getRandomQuestion());
    }

}
