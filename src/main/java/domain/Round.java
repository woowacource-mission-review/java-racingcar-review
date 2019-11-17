package domain;

import domain.exception.InvalidRoundNumberException;

public class Round {
    private static final Integer MIN_ROUND_NUMBER = 1;
    private final Integer round;

    public Round(String round) {
        validRound(round);
        this.round = Integer.parseInt(round);
    }

    private void validRound(String round) {
        if (!isNumeric(round)) {
            throw new InvalidRoundNumberException();
        }

        if (Integer.parseInt(round) < MIN_ROUND_NUMBER) {
            throw new InvalidRoundNumberException();
        }
    }

    private static boolean isNumeric(String number) {
        try {
            Double.parseDouble(number);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }

    public Integer getNumber() {
        return round;
    }
}
