package model.result;

public class GameResult {
    private final RoundResults roundResults;
    private final WinnerResult winnerResult;

    public GameResult(final RoundResults roundResults, final WinnerResult winnerResult) {
        this.roundResults = roundResults;
        this.winnerResult = winnerResult;
    }

    public RoundResults getRoundResults() {
        return roundResults;
    }

    public WinnerResult getWinnerResult() {
        return winnerResult;
    }
}
