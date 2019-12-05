package racingcar.domain.car;

import racingcar.domain.movestrategy.MoveStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
    public static final int MINIMUM_NAMES = 2;
    private static final String DELIMITER = ",";

    private List<Car> cars;

    public Cars(final String names) {
        this.cars = createCars(names);
        validateCarSize();
    }

    private void validateCarSize() {
        if (cars.size() < MINIMUM_NAMES) {
            throw new IllegalArgumentException(MINIMUM_NAMES + "명 이상 입력해주세요.");
        }
    }

    private List<Car> createCars(final String names) {
        return Stream.of(names.split(DELIMITER))
                .map(Car::of)
                .collect(Collectors.toList());
    }

    public List<Car> tryMove(final MoveStrategy moveStrategy) {
        this.cars = cars.stream()
                .map(car -> car.tryMove(moveStrategy))
                .collect(Collectors.toList());
        return cars;
    }
}
