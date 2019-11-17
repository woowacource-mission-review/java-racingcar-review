package racing.controller;

import racing.model.RacingCar;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<RacingCar> cars;
    private final int numOfRaces;

    public RacingGame(List<String> carNames, int numOfRaces) {
        this.cars = carNames.stream()
                .map(RacingCar::new)
                .collect(Collectors.toList());
        this.numOfRaces = numOfRaces;
    }

    public List<RacingCar> getCars() {
        return this.cars;
    }
}
