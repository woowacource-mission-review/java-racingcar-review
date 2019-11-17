package model.result;

public class GameResult {
    private RoundResults roundResults;
    private WinnerResult winnerResult;

    public GameResult(RoundResults roundResults, WinnerResult winnerResult) {
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
