package model.result;

import model.Car;

import java.util.Iterator;
import java.util.List;

public class WinnerResult implements Iterable<String> {
    private final List<String> winnerNames;

    public WinnerResult(final List<String> winnerNames) {
        this.winnerNames = winnerNames;
    }

    public boolean contains(final Car car) {
        return winnerNames.contains(car.getName());
    }

    @Override
    public Iterator<String> iterator() {
        return winnerNames.iterator();
    }
}
