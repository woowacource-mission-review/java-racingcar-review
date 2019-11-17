package com.woowacourse.racingcar.domain;

import com.woowacourse.racingcar.domain.validator.GameNumberValidator;

import java.util.Objects;

public class GameNumber {

    private int gameNumber;

    public GameNumber(final int gameNumber) {
        GameNumberValidator.check(gameNumber);
        this.gameNumber = gameNumber;
    }

    public int getNumber() {
        return this.gameNumber;
    }

    public void plusOne() {
        this.gameNumber++;
    }

    public boolean isNotEquals(final GameNumber gameNumber) {
        return this.gameNumber != gameNumber.gameNumber;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final GameNumber that = (GameNumber) o;
        return gameNumber == that.gameNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameNumber);
    }


}
