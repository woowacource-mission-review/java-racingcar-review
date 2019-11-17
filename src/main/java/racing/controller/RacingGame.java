package racing.controller;

import racing.model.RacingCar;
import racing.model.RacingCarProceedStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<RacingCar> cars;
    private final RacingCarProceedStrategy proceedStrategy;

    public RacingGame(List<String> carNames, RacingCarProceedStrategy proceedStrategy) {
        this.cars = carNames.stream()
                .map(RacingCar::new)
                .collect(Collectors.toList());
        this.proceedStrategy = proceedStrategy;
    }

    public List<RacingCar> getCars() {
        return this.cars;
    }

    public void proceed() {
        for (RacingCar car : cars) {
            car.goForward(proceedStrategy);
        }
    }
}
