package besedin.questionService.exceptions;

public class NullQuestionException extends IllegalArgumentException{
    public NullQuestionException(String msg) {
        super(msg);
    }

    public NullQuestionException() {
        super();
    }
}
