package com.woowacourse.racingcar.domain;

import java.util.Objects;

public class GameNumber {

    private final int gameNumber;

    public GameNumber(final int gameNumber) {
        this.gameNumber = gameNumber;
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
