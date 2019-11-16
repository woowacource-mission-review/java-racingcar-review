package racingcar.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
    private static final String DELIMITER = ",";

    private final List<Car> cars;

    public Cars(final String names) {
        this.cars = createCars(names);
    }

    private List<Car> createCars(final String names) {
        return Stream.of(names.split(DELIMITER))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void move(final MoveStrategy moveStrategy) {
        cars.forEach(car -> car.move(moveStrategy));
    }

    public List<Car> getCars() {
        return cars;
    }


    public List<String> getWinners() {
        int maxOfPosition = cars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .get().getPosition();

        return cars.stream()
                .filter(car -> car.isSamePosition(maxOfPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
