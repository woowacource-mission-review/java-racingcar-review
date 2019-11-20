package racingcar.domain.race;

import racingcar.domain.car.Cars;
import racingcar.domain.exception.RaceStatusEmptyException;
import racingcar.service.dto.CarDto;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RaceStatus {
    private final List<CarDto> carDtos;

    public RaceStatus(final List<CarDto> carDtos) {
        if (carDtos.size() < Cars.MINIMUM_NAMES) {
            throw new RaceStatusEmptyException();
        }
        this.carDtos = carDtos;
    }

    public static RaceStatus from(final List<CarDto> carDtos) {
        return new RaceStatus(carDtos);
    }

    public List<CarDto> getCurrentWinners() {
        final int maxOfPosition = getMaxOfPosition();

        return carDtos.stream()
                .filter(carDto -> carDto.getPosition() == maxOfPosition)
                .collect(Collectors.toList());
    }

    private int getMaxOfPosition() {
        return carDtos.stream()
                .max(Comparator.comparingInt(CarDto::getPosition))
                .orElseThrow(RaceStatusEmptyException::new)
                .getPosition();
    }

    public List<CarDto> getCurrentRaceStatus() {
        return carDtos;
    }
}
