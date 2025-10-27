package racingcar.domain.Parser;

import java.util.Arrays;
import java.util.List;

public class CommaParser implements Parser {
    private static final String COMMA_DELIMITER = ",";
    private static final CommaParser INSTANCE = new CommaParser();

    private CommaParser() {}

    public static CommaParser getInstance() {
        return INSTANCE;
    }

    @Override
    public List<String> parse(String carNames) {
        return Arrays.stream(carNames.split(COMMA_DELIMITER))
                .toList();
    }
}
