package model;

import model.exception.InvalidRoundException;

import java.util.Iterator;

public class Round implements Iterable<Integer> {
    public static final int MIN_ROUND = 1;

    private final int round;

    Round(final String round) {
        int intRound = convertToInteger(round);
        validate(intRound);
        this.round = intRound;
    }

    private int convertToInteger(final String round) {
        try {
            return Integer.parseInt(round);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(MIN_ROUND + "이상의 정수를 입력해주세요.");
        }
    }

    private void validate(final int round) {
        if (round < MIN_ROUND) {
            throw new InvalidRoundException("라운드는 1이상의 정수여야 합니다.");
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int currentRound = 0;
            int maxRound = round;

            @Override
            public boolean hasNext() {
                return currentRound < maxRound;
            }

            @Override
            public Integer next() {
                return ++currentRound;
            }
        };
    }
}
