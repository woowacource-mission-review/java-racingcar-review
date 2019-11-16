package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static model.RacingCarGame.CAR_NAME_DELIMITER;
import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarGameTest {
    private RacingCarGame racingCarGame = new RacingCarGame();

    @Test
    @DisplayName("차 등록 성공")
    void register() {
        String carNames = "ABC,DEF,GHI,JKL";
        assertThat(racingCarGame.register(carNames)).isTrue();
    }

    @Test
    @DisplayName("Empty String 이름으로 차 등록시 False 리턴")
    void register_null_error() {
        String carNames = "";
        assertThat(racingCarGame.register(carNames)).isFalse();
    }

    @Test
    @DisplayName("Comma만 있는 String으로 차 등록시 False 리턴")
    void register_only_commas_error() {
        String carNames = CAR_NAME_DELIMITER + CAR_NAME_DELIMITER;
        assertThat(racingCarGame.register(carNames)).isFalse();
    }
}
