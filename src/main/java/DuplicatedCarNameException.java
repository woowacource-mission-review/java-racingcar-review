public class DuplicatedCarNameException extends RuntimeException{
    private static final String MESSAGE = "중복된 이름을 입력할 수 없습니다.";

    public DuplicatedCarNameException() {
        super(MESSAGE);
    }
}
