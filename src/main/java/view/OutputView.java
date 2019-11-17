package view;

import model.result.GameResult;
import model.result.MoveResult;
import model.result.RoundResult;
import model.result.WinnerResult;

public class OutputView {
    public void showErrorMessage(RuntimeException e) {
        System.out.println(e.getMessage());
    }

    public void showResults(GameResult gameResult) {
        System.out.println("\n실행결과");

        for (RoundResult roundResult : gameResult.getRoundResults()) {
            showRoundResult(roundResult);
        }
        showWinners(gameResult.getWinnerResult());
    }

    private void showRoundResult(RoundResult roundResult) {
        for (MoveResult moveResult : roundResult) {
            showMoveResult(moveResult);
        }
        System.out.println();
    }

    private void showMoveResult(MoveResult moveResult) {
        System.out.printf("%s : ", moveResult.getName());
        for (int i = 0; i < moveResult.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    private void showWinners(WinnerResult winnerResult) {
        System.out.println(String.join(", ", winnerResult) + "가 최종 우승했습니다.");
    }
}
