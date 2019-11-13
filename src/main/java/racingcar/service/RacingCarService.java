package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.exception.DuplicateCarsException;
import racingcar.exception.LackOfCarsException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RacingCarService {

    private static final String CAR_NAME_DELIMITER = ",";
    public static final int MIN_NUM_OF_RACING_CARS = 2;

    public Cars createCarsByParsingWith(String names) {
        String[] nameTokens = names.split(CAR_NAME_DELIMITER);
        if (nameTokens.length < MIN_NUM_OF_RACING_CARS) {
            throw new LackOfCarsException();
        }

        List<String> carNames = trim(nameTokens);

        if (hasDuplicateNamesIn(carNames)) {
            throw new DuplicateCarsException();
        }

        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        return new Cars(cars);
    }

    private boolean hasDuplicateNamesIn(List<String> names) {
        Set<String> nameSet = new HashSet<>(names);

        return names.size() != nameSet.size();
    }

    private List<String> trim(final String[] nameTokens) {
        return Arrays.stream(nameTokens)
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
