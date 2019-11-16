package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CarsTest {

    @Test
    @DisplayName(",가 아닌 다른 delimiter를 사용한 경우")
    void createTest() {
        assertThrows(IllegalArgumentException.class, ()-> new Cars("pobi:crong.honux"));
    }

}