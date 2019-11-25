package racingcar.view;

import racingcar.domain.RacingGameResult;

public interface OutputView {
    void showExceptionMessageForPlayer(IllegalArgumentException e);

    void showGameProcess(RacingGameResult result);

    void showWinners(RacingGameResult result);
}
