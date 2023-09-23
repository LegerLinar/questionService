package besedin.questionService;

import besedin.questionService.interfaces.ExaminerService;
import besedin.questionService.model.Question;
import besedin.questionService.service.ExaminerServiceImpl;
import besedin.questionService.service.JavaQuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)

public class ExaminerServiceTest {
    @Mock
    private JavaQuestionService questionsMock;
    @InjectMocks
    private ExaminerServiceImpl out;


    /**
     * constants
     */
    final static String FIRST_QUESTION = "FIRST";
    final static String FIRST_ANSWER = "FIRST_A";
    final static String SECOND_QUESTION = "SECOND";
    final static String SECOND_ANSWER = "SECOND_A";
    final static String THIRD_QUESTION = "THIRD";
    final static String THIRD_ANSWER = "THIRD_A";
    final static Question QUESTION_FIRST = new Question(FIRST_QUESTION, FIRST_ANSWER);
    final static Question QUESTION_SECOND = new Question(SECOND_QUESTION, SECOND_ANSWER);

    @Test
    public void shouldReturnSomeQuestion() {
        when(questionsMock.getRandomQuestion()).
                thenReturn(QUESTION_FIRST);
        Collection<Question> actual = out.getQuestions(1);
        Collection<Question> expected = new ArrayList<>(List.of( QUESTION_FIRST));

        assertIterableEquals(expected,actual);
    }

    @Test
    public void shouldReturnExactSize() {
        when(questionsMock.getRandomQuestion()).
                thenReturn(QUESTION_FIRST);
        Collection actual = out.getQuestions(3);
        assertEquals(3,actual.size());
    }



}
