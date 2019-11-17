package model.result;

import model.Car;

import java.util.List;

public class WinnerResult {
    private List<String> winnerNames;

    public WinnerResult(List<String> winnerNames) {
        this.winnerNames = winnerNames;
    }

    public boolean contains(Car car) {
        return winnerNames.contains(car.getName());
    }
}
