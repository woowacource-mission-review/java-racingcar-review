package racingcar.domain.race;

import racingcar.service.dto.CarDto;

import java.util.Iterator;
import java.util.List;

public class RaceResult implements Iterator {
    private final List<RaceStatus> raceStatuses;
    private int cursor;

    public RaceResult(final List<RaceStatus> raceStatuses) {
        this.raceStatuses = raceStatuses;
        this.cursor = 0;
    }

    public List<CarDto> getWinners() {
        final int lastIndex = raceStatuses.size() - 1;
        return raceStatuses.get(lastIndex).getCurrentWinners();
    }

    @Override
    public boolean hasNext() {
        return raceStatuses.size() > cursor;
    }

    @Override
    public List<CarDto> next() {
        final List<CarDto> currentRaceStatus = raceStatuses.get(cursor).getCurrentRaceStatus();
        cursor++;
        return currentRaceStatus;
    }
}
