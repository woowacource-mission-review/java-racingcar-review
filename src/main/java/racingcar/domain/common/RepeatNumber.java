package racingcar.domain.common;

import java.util.Objects;

public class RepeatNumber {
    private static final int NUMBER_BOUNDARY = 1;

    private final int number;

    private RepeatNumber(final int number) {
        if (number < NUMBER_BOUNDARY) {
            throw new IllegalArgumentException(NUMBER_BOUNDARY + " 이상 입력해주세요.");
        }
        this.number = number;
    }

    public static RepeatNumber from(final int number) {
        return new RepeatNumber(number);
    }


    public static RepeatNumber from(final String number) {
        try {
            final int parsedNumber = Integer.parseInt(Objects.requireNonNull(number));
            return new RepeatNumber(parsedNumber);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자를 입력해주세요");
        }
    }

    public int getNumber() {
        return number;
    }
}
