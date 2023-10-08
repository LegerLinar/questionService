package besedin.questionService.controller;

import besedin.questionService.interfaces.ExaminerService;
import besedin.questionService.interfaces.QuestionService;
import besedin.questionService.model.Question;
import besedin.questionService.service.JavaQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(path = "/exam/java")

public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public Collection<Question> getAll() {
        return questionService.getAll();
    }

    @PostMapping(path = "/add")
    public String addQuestion(@RequestParam("question") String question,
                              @RequestParam("answer") String answer) {
        return questionService.add(question, answer).toString() + " Добавлен";

    }

    @DeleteMapping(path = "remove")
    public String removerQuestion(@RequestParam("question") String question) {
        return questionService.remove(question).toString() + " Удален";
    }


    /**
     * Контроллер должен иметь три метода: добавить, удалить и получить все вопросы.
     *
     * Эти методы должны висеть на следующих эндпоинтах:
     *
     * Добавить: “/exam/java/add?question=QuestionText&answer=QuestionAnswer”
     *
     * Удалить: “/exam/java/remove?question=QuestionText&answer=QuestionAnswer”
     *
     * Получить все вопросы: “/exam/java”
     */
}
