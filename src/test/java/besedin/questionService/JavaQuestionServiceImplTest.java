package besedin.questionService;

import besedin.questionService.exceptions.NullQuestionException;
import besedin.questionService.exceptions.QuestionAlreadyExistException;
import besedin.questionService.interfaces.QuestionService;
import besedin.questionService.model.Question;
import besedin.questionService.service.JavaQuestionService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JavaQuestionServiceImplTest {
    /**
     * Constants
     */
    final static String NORMAL_QUESTION = "Question";
    final static String NORMAL_ANSWER = "ANSWER";
    final static String NULL_QUESTION = null;
    final static String NULL_ANSWER = null;
    final static String BLANK_QUESTION = "";
    final static String BLANK_ANSWER = "";

    /**
     * test start
     */
    private final QuestionService out = new JavaQuestionService();


    @Test
    public void shouldAddAndReturn() {
        Question actual = out.add(new Question(NORMAL_QUESTION, NORMAL_ANSWER));
        Question expected = new Question(NORMAL_QUESTION, NORMAL_ANSWER);

        Collection<Question> actualCollection = out.getAll();
        Collection<Question> expectedCollection = new ArrayList<>(List.of(expected));

        assertEquals(expected, actual);
        assertIterableEquals(expectedCollection, actualCollection);
    }

    @Test
    public void shouldThrowAgainstAdd() {
        assertThrows(NullQuestionException.class,
                () -> out.add(NULL_QUESTION, NORMAL_ANSWER));
    assertThrows(NullQuestionException.class,
                () -> out.add(NORMAL_QUESTION, NULL_ANSWER));
        assertThrows(NullQuestionException.class,
                () -> out.add(BLANK_QUESTION, NORMAL_ANSWER));
        assertThrows(NullQuestionException.class,
                () -> out.add(NORMAL_QUESTION, BLANK_ANSWER));
    }

    @Test
    public void shouldThrowIfAlreadyExist() {
        out.add(NORMAL_QUESTION, NORMAL_ANSWER);
        assertThrows(QuestionAlreadyExistException.class,
                () -> out.add(NORMAL_QUESTION,NORMAL_ANSWER));
    }


    @Test
    public void shouldRemoveAndReturn() {
        Question actual = out.remove(NORMAL_QUESTION);
        Question expected = new Question(NORMAL_QUESTION, NORMAL_ANSWER);

        Collection<Question> actualCollection = out.getAll();
        Collection<Question> expectedCollection = new ArrayList<>();

        assertEquals(expected,actual);
        assertIterableEquals(expectedCollection,actualCollection);

    }


    @Test
    public void shouldThrowAgainstRemove(){
        assertThrows(NullQuestionException.class,
                () -> out.remove(NORMAL_QUESTION));
        assertThrows(NullQuestionException.class,
                () -> out.remove(NORMAL_QUESTION));
    }
    @Test
    public void shouldGetAll() {
        Collection<Question> actual = out.getAll();
        Collection<Question> expected = new ArrayList<>();

        assertIterableEquals(expected,actual);
    }

    @Test
    public void shouldGetRandomQuestion() {
        out.add(NORMAL_QUESTION, NORMAL_ANSWER);
        out.add("FOR_TEST", "FOR_TEST");
        out.add("RANDOM_TEXT", "RANDOM_TEXT");

        Question actual = out.getRandomQuestion();
        assertTrue(out.getAll().contains(actual));
    }
}
