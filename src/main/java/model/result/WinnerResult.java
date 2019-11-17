package model.result;

import model.Car;

import java.util.Iterator;
import java.util.List;

public class WinnerResult implements Iterable<String> {
    private List<String> winnerNames;

    public WinnerResult(List<String> winnerNames) {
        this.winnerNames = winnerNames;
    }

    public boolean contains(Car car) {
        return winnerNames.contains(car.getName());
    }

    public List<String> getWinnerNames() {
        return winnerNames;
    }


    @Override
    public Iterator<String> iterator() {
        return winnerNames.iterator();
    }
}
