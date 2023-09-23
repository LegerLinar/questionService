package besedin.questionService.controller;

import besedin.questionService.interfaces.ExaminerService;
import besedin.questionService.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping(path = "/{amount}")
    public Collection<Question> getExam(@PathVariable("amount") int amount){
        return examinerService.getQuestions(amount);
    }
}
