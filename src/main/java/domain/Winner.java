package domain;

import java.util.Objects;

public class Winner {
    private Car winnerCar;

    public Winner(Car winnerCar) {
        this.winnerCar = winnerCar;
    }

    public String getWinnerName() {
        return winnerCar.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Winner winner = (Winner) o;
        return Objects.equals(winnerCar, winner.winnerCar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winnerCar);
    }
}
