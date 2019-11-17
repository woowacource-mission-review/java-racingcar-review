package racing.model;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ResultStatistics {
    private final List<RacingCar> cars;

    public ResultStatistics(List<RacingCar> cars) {
        this.cars = cars;
    }

    public List<RacingCar> findWinners() {
        int maxPosition = findMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private int findMaxPosition() {
        return cars.stream()
                .max(Comparator.comparingInt(RacingCar::getPosition))
                .get()
                .getPosition();
    }
}
