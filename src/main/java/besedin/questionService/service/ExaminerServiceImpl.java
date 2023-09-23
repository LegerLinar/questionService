package besedin.questionService.service;

import besedin.questionService.interfaces.ExaminerService;
import besedin.questionService.interfaces.QuestionService;
import besedin.questionService.model.Question;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Service

public class ExaminerServiceImpl implements ExaminerService {
    /**
     *
     * Должен вернуть сформированный список рандомных вопросов из QuestionService
     */
    private QuestionService questionService;
    public ExaminerServiceImpl(QuestionService questionService){
        this.questionService = questionService;
    }
    @Override
    public Collection<Question> getQuestions(int amount) {
        List<Question> questions = new ArrayList<>();
        for(int i = 0; i < amount; i++){
            questions.add(questionService.getRandomQuestion());
        }
        return questions;
    }
}
