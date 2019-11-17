package racingcar.domain;

public class RepeatNumber {
    private static final int NUMBER_BOUNDARY = 1;

    private final int number;

    public RepeatNumber(final int number) {
        if (number < NUMBER_BOUNDARY) {
            throw new IllegalArgumentException("1 이상 입력해주세요.");
        }
        this.number = number;
    }

    public static RepeatNumber from(final int number) {
        return new RepeatNumber(number);
    }


    public static RepeatNumber from(final String number) {
        return new RepeatNumber(Integer.parseInt(number));
    }

    public int getNumber() {
        return number;
    }
}
