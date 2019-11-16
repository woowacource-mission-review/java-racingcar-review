package model;

import model.exception.InvalidRoundException;

class Round {
    private int round;

    Round(int round) {
        validate(round);
        this.round = round;
    }

    private void validate(int round) {
        if (round < 1) {
            throw new InvalidRoundException("라운드는 1이상의 정수여야 합니다.");
        }
    }
}
