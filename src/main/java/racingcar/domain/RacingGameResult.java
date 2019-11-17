package racingcar.domain;

public class RacingGameResult {

    private final RacingGameHistory history;

    public RacingGameResult(final RacingGameHistory history) {
        this.history = history;
    }

    public RacingCars read(final long round) {
        return history.read(new GameRound(round));
    }

    public long getNumOfGameRounds() {
        return history.getNumOfGameRounds();
    }
}
