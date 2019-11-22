package com.woowacourse.racingcar.domain;

import com.google.common.collect.Lists;

import java.util.List;

public class GameResult {

    private static final int ONE = 1;
    private List<Cars> result;

    public GameResult() {
        result = Lists.newArrayList();
    }

    public void addResult(Cars cars) {
        result.add(cars);
    }

    public Cars get(int index) {
        return result.get(index);
    }

    public int getSize() {
        return result.size();
    }

    public List<Car> getWinners() {
        int lastIndex = result.size() - ONE;
        return result.get(lastIndex).findWinners();
    }
}
