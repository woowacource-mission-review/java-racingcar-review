package racing.controller;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {
    @DisplayName("이름 리스트를 통해 레이싱 카들을 생성한다.")
    @Test
    void createRacingCarsFromNamesListTest() {
        List<String> carNames = Lists.newArrayList("moomin", "baedi", "comac", "JM", "EZ");
        RacingGame racingGame = new RacingGame(carNames, () -> true);
        Assertions.assertNotNull(racingGame.getCars());
    }

    @DisplayName("레이싱 카들을 전진 또는 멈춘다.")
    @Test
    void proceedRacingTest() {
        List<String> carNames = Lists.newArrayList("moomin", "baedi", "comac", "JM", "EZ");
        RacingGame racingGame = new RacingGame(carNames, () -> true);
        racingGame.proceed();
        assertThat(racingGame.getCars()
                .stream()
                .filter(car -> car.getPosition() == 1).count())
                .isEqualTo(carNames.size());
    }
}