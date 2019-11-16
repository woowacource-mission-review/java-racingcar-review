package racingcar.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
    private static final String DELIMITER = ",";
    private static final int MINIMUM_NAMES = 2;

    private final List<Car> cars;

    public Cars(final String names) {
        this.cars = createCars(names);
        if (cars.size() < MINIMUM_NAMES) {
            throw new IllegalArgumentException("2명 이상 입력해주세요.");
        }
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
