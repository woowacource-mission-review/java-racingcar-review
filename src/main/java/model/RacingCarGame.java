package model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {
    public static final String CAR_NAME_DELIMITER = ",";

    private RacingCars racingCars;

    public void registerCar(String rawCarNames) {
        racingCars = new RacingCars(convertRawCarNamesToCars(rawCarNames));
    }

    private List<Car> convertRawCarNamesToCars(String rawCarNames) {
        return Arrays.stream(rawCarNames.split(CAR_NAME_DELIMITER))
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
