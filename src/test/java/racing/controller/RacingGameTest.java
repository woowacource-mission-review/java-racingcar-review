package racing.controller;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class RacingGameTest {
    @DisplayName("이름 리스트를 통해 레이싱 카들을 생성한다.")
    @Test
    void createRacingCarsFromNamesList() {
        List<String> carNames = Lists.newArrayList("moomin", "baedi", "comac", "JM", "EZ");
        int numOfRaces = 5;
        RacingGame racingGame = new RacingGame(carNames, numOfRaces);
        Assertions.assertNotNull(racingGame.getCars());
    }
}