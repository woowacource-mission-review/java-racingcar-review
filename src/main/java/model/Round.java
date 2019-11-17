package model;

import model.exception.InvalidRoundException;

import java.util.Iterator;

class Round implements Iterable<Integer> {
    public static final int MIN_ROUND = 1;

    private int round;

    Round(int round) {
        validate(round);
        this.round = round;
    }

    private void validate(int round) {
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
