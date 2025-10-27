package racingcar.dto;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameRequestDtoTest {

    @Test
    @DisplayName("자동차 이름이 비어있으면 예외가 발생한다")
    void carName_isEmpty() {
        assertThatThrownBy(() -> GameRequestDto.from(" ", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름 목록 문자열은 비어 있으면 안됩니다");
    }

    @Test
    @DisplayName("시도 횟수가 비어있으면 예외가 발생한다")
    void numberOfAttempts_isEmpty() {
        assertThatThrownBy(() -> GameRequestDto.from("pobi,woni", " "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수가 비어 있으면 안됩니다");
    }

    @Test
    @DisplayName("시도 횟수가 숫자가 아니면 예외가 발생한다")
    void numberOfAttempts_shouldIntege() {
        assertThatThrownBy(() -> GameRequestDto.from("pobi,woni", "five"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 숫자여야 합니다");
    }

    @Test
    @DisplayName("유효한 값이 들어오면 GameRequestDto가 정상적으로 생성된다")
    void validGameRequestDto() {
        assertThatCode(() -> GameRequestDto.from("pobi,woni", "5"))
                .doesNotThrowAnyException();
    }

}
