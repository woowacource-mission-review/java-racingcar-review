package racingcar.domain.race;

import racingcar.service.dto.CarDto;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RaceStatus {
    private final List<CarDto> carDtos;

    public RaceStatus(final List<CarDto> carDtos) {
        this.carDtos = carDtos;
    }

    public static RaceStatus from(final List<CarDto> carDtos) {
        return new RaceStatus(carDtos);
    }

    public List<CarDto> getCurrentWinners() {
        final int maxOfPosition = carDtos.stream()
                .max(Comparator.comparingInt(CarDto::getPosition))
                .get().getPosition();

        return carDtos.stream()
                .filter(carDto -> carDto.getPosition() == maxOfPosition)
                .collect(Collectors.toList());
    }

    public List<CarDto> getCurrentRaceStatus() {
        return carDtos;
    }
}
