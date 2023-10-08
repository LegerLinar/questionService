package besedin.questionService.interfaces;

import besedin.questionService.model.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer);

    Question add(Question question);

    Question remove(String question);

    Collection<Question> getAll();

    Question getRandomQuestion();
}
