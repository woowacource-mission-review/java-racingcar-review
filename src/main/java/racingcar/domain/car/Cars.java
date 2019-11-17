package racingcar.domain.car;

import racingcar.domain.movestrategy.MoveStrategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
    public static final int MINIMUM_NAMES = 2;
    private static final String DELIMITER = ",";

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

    public List<Car> shouldMove(final MoveStrategy moveStrategy) {
        cars.forEach(car -> car.shouldMove(moveStrategy));
        return Collections.unmodifiableList(cars);
    }
}
