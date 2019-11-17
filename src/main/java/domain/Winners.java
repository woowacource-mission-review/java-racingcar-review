package domain;

import java.util.List;

public class Winners {
    private List<Winner> winners;

    public Winners(List<Winner> winners) {
        this.winners = winners;
    }

    public List<Winner> getWinners() {
        return winners;
    }
}
