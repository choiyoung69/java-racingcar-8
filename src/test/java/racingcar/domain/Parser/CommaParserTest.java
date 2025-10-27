package racingcar.domain.Parser;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CommaParserTest {

    private final CommaParser parser = CommaParser.getInstance();

    @Test
    @DisplayName("콤마(,) 기준으로 문자열을 올바르게 분리한다")
    void parse() {
        String input = "pobi,woni,jun";

        List<String> result = parser.parse(input);

        Assertions.assertThat(result).containsExactly("pobi", "woni", "jun");
    }
}