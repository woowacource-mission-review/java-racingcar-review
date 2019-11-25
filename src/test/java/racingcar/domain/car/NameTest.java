package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.IllegalNameException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NameTest {

    @Test
    @DisplayName("이름 객체 생성 테스트")
    void createName() {
        String newName = "이름";
        Name name = new Name(newName);

        assertThat(name.getInnerName()).isEqualTo(newName);
    }

    @Test
    void equals() {
        assertThat(new Name("sameName")).isEqualTo(new Name("sameName"));
    }

    @Test
    @DisplayName("이름이 null, 빈 문자열, 공백일 경우 예외 발생")
    void blankName() {
        assertThrows(IllegalNameException.class, () -> new Name(null));
        assertThrows(IllegalNameException.class, () -> new Name(""));
        assertThrows(IllegalNameException.class, () -> new Name(" "));
    }

    @Test
    void isLengthLongerThan() {
        Name name = new Name("green");

        assertThat(name.isLengthLongerThan(4)).isTrue();
        assertThat(name.isLengthLongerThan(5)).isFalse();
    }
}