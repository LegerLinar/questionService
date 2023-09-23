package besedin.questionService.service;

import besedin.questionService.exceptions.NullQuestionException;
import besedin.questionService.exceptions.QuestionAlreadyExistException;
import besedin.questionService.interfaces.QuestionService;
import besedin.questionService.model.Question;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class JavaQuestionService implements QuestionService {
    private HashMap<String, Question> questionMap = new HashMap<>(Map.of(
            "Где можно объявить метод?",
            new Question("Где можно объявить метод?", "Метод можно объявить внутри класса"),
            "В чем отличие между разными типами переменных?",
            new Question("В чем отличие между разными типами переменных?", "В объеме занимаемой памяти в компьютере"),
            "Какие модификаторы доступа есть в Java? ",
            new Question("Какие модификаторы доступа есть в Java? ", "public, default (package), protected, private"),
            "Как называется пространство для хранения переменных объектного типа?",
            new Question("Как называется пространство для хранения переменных объектного типа?", "Heap / Куча"),
            "Что такое сборщик мусора в Java?",
            new Question("Что такое сборщик мусора в Java?", "Встроенный механизм в Java, который удаляет из памяти все недоступные или неиспользуемые объекты;"),
            "Что такое пул строк?",
            new Question("Что такое пул строк?", "Механизм, который позволяет хранить в памяти компьютера только один экземпляр строки с идентичным содержанием;")
    ));

    @Override
    public Question add(String question, String answer) {
        if (question == null) {
            throw new NullQuestionException("Please, add correct question");
        }
        if (answer == null) {
            throw new NullQuestionException("Please, add correct answer");
        }
        Question temp = new Question(question, answer);
        if(!(questionMap.put(temp.getQuestion(), temp) == null)){
            throw new QuestionAlreadyExistException();
        }
        return temp;
    }

    @Override
    public Question add(Question question) {
        if (question == null) {
            throw new NullQuestionException("Question is nullable");
        }
        questionMap.put(question.getQuestion(), question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        Question temp = questionMap.remove(question.getQuestion());
        if(temp == null){
            throw new NullQuestionException();
        }
        return temp;
    }

    @Override
    public Collection<Question> getAll() {
        return questionMap.values();
    }

    @Override
    public Question getRandomQuestion() {
        int randomIndex = new Random().nextInt(questionMap.size());
        int index = 0;
        Question randomQuestion = null;
        for (Question question : questionMap.values()) {
            if (index == randomIndex) {
                randomQuestion = question;
            }
            index++;
        }
        return randomQuestion;
    }
}
