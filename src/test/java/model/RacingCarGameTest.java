package model;

import model.exception.CarCreateException;
import model.exception.InvalidRoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static model.RacingCarGame.CAR_NAME_DELIMITER;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RacingCarGameTest {
    private RacingCarGame racingCarGame = new RacingCarGame();

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
        assertThrows(CarCreateException.class, () -> racingCarGame.registerCar(carNames));
    }

    @Test
    @DisplayName("1이상 정수로 라운드 등록")
    void register_round() {
        assertDoesNotThrow(() -> racingCarGame.registerRound(1));
    }

    @Test
    @DisplayName("1미만 정수로 라운드 등록시 에러 발생")
    void register_over_1_round() {
        assertThrows(InvalidRoundException.class, () -> racingCarGame.registerRound(0));
    }
}
