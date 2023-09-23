package besedin.questionService.interfaces;

import besedin.questionService.model.Question;

import java.util.Collection;
import java.util.List;

public interface ExaminerService {
    Collection<Question> getQuestions();
}
