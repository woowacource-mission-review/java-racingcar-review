package model;

import model.exception.CarCreateException;
import model.exception.InvalidRegistrationException;
import model.exception.InvalidRoundException;
import model.result.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static model.RacingCarGame.CAR_NAME_DELIMITER;
import static model.Round.MIN_ROUND;
import static org.junit.jupiter.api.Assertions.*;

public class RacingCarGameTest {
    private RacingCarGame racingCarGame = new RacingCarGame(new DefaultRandomMoveStrategy());

    @Test
    @DisplayName("차 등록 성공")
    void register() {
        String carNames = "ABC,DEF,GHI,JKL";
        assertDoesNotThrow(() -> racingCarGame.registerCar(carNames));
    }

    @Test
    @DisplayName("Empty String 이름으로 차 등록시 에러 발생")
    void register_null_error() {
        String carNames = "";
        assertThrows(CarCreateException.class, () -> racingCarGame.registerCar(carNames));
    }

    @Test
    @DisplayName("Comma만 있는 String으로 차 등록시 에러 발생")
    void register_only_commas_error() {
        String carNames = CAR_NAME_DELIMITER + CAR_NAME_DELIMITER;
        assertThrows(InvalidRegistrationException.class, () -> racingCarGame.registerCar(carNames));
    }

    @Test
    @DisplayName("하나의 이름으로 차 등록시 에러 발생")
    void register_one_name_error() {
        String carNames = "ABC";
        assertThrows(InvalidRegistrationException.class, () -> racingCarGame.registerCar(carNames));
    }

    @Test
    @DisplayName("중복된 이름으로 차 등록시 에러 발생")
    void register_duplicated_name_error() {
        String carNames = "ABC,ABC";
        assertThrows(InvalidRegistrationException.class, () -> racingCarGame.registerCar(carNames));
    }

    @Test
    @DisplayName("1이상 정수로 라운드 등록")
    void register_round() {
        assertDoesNotThrow(() -> racingCarGame.registerRound(String.valueOf(MIN_ROUND)));
    }

    @Test
    @DisplayName("1미만 정수로 라운드 등록시 에러 발생")
    void register_over_1_round() {
        assertThrows(InvalidRoundException.class, () -> racingCarGame.registerRound(String.valueOf(MIN_ROUND - 1)));
    }

    @Test
    @DisplayName("게임 결과 확인")
    void game_result() {
        racingCarGame = new RacingCarGame(new AlwaysTrueMoveStrategy());
        racingCarGame.registerCar("ABC,DEF");
        racingCarGame.registerRound(String.valueOf(2));
        GameResult gameResult = racingCarGame.startGame();

        WinnerResult winnerResult = gameResult.getWinnerResult();
        assertWinnerResult(winnerResult);

        RoundResults roundResults = gameResult.getRoundResults();
        int position = 1;
        for (RoundResult roundResult : roundResults) {
            assertRoundResult(position, roundResult);
            position++;
        }
    }

    private void assertWinnerResult(final WinnerResult winnerResult) {
        assertTrue(winnerResult.contains(new Car("ABC")));
        assertTrue(winnerResult.contains(new Car("DEF")));
    }

    private void assertRoundResult(final int position, final RoundResult roundResult) {
        assertTrue(roundResult.contains(new MoveResult("ABC", position)));
        assertTrue(roundResult.contains(new MoveResult("DEF", position)));
    }
}
