package support;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarNameUtilsTest {

    @Test
    @DisplayName("아무것도 입력받지 않았을 때")
    void parse_empty() {
        String inputNames = "";
        List<String> carNames = CarNameUtils.parse(inputNames);

        assertThat(carNames).contains("");
        assertThat(carNames.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("'pobi,crong,honux'으로 입력받은 문자열을 쉼표 기준으로 구분하여 스트링 배열로 반환한다.")
    void parse_car_name() {
        String inputNames = "pobi,crong,honux";
        List<String> carNames = CarNameUtils.parse(inputNames);

        assertThat(carNames).contains("pobi", "crong", "honux");
        assertThat(carNames.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("' pobi, crong , honux '으로 입력받은 경우 앞뒤 공백을 모두 정상적으로 제거하는지 검사한다.")
    void parse_include_empty() {
        String inputNames = " pobi, crong , honux ";
        List<String> carNames = CarNameUtils.parse(inputNames);

        assertThat(carNames).contains("pobi", "crong", "honux");
        assertThat(carNames.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("중복된 이름을 입력한 경우 오류를 반환한다.")
    void parse_duplicate_name() {
        String inputNames = "comac, comac";
        assertThrows(DuplicatedCarNameException.class, () -> CarNameUtils.parse(inputNames));
    }
}
