package racingcar.exception;

import racingcar.domain.gameround.GameRound;

public class LackOfGameCountException extends IllegalArgumentException {

    private static final String LACK_OF_GAME_COUNT_MESSAGE
            = "게임 횟수는 " + GameRound.MIN_NUM_OF_GAME_ROUND + " 이상의 수로 입력해 주세요.";

    public LackOfGameCountException() {
        super(LACK_OF_GAME_COUNT_MESSAGE);
    }
}
