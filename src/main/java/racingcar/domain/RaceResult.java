package racingcar.domain;

import racingcar.service.dto.CarDto;

import java.util.List;

public class RaceResult {
    private final List<RaceStatus> raceStatuses;

    public RaceResult(final List<RaceStatus> raceStatuses) {
        this.raceStatuses = raceStatuses;
    }

    public List<CarDto> getWinners() {
        final int lastIndex = raceStatuses.size() - 1;
        return raceStatuses.get(lastIndex).getCurrentWinners();
    }

    public List<RaceStatus> getRaceStatuses() {
        return raceStatuses;
    }
}
