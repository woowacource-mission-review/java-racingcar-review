public class CarsEmptyException extends RuntimeException {
    private static final String MESSAGE = "자동차 리스트가 비어있습니다.";

    public CarsEmptyException() {
        super(MESSAGE);
    }
}
