package racingcar.dto;

import static racingcar.util.ValidationUtils.validateAndParseInt;
import static racingcar.util.ValidationUtils.validateNotBlank;

public record GameRequestDto(String carNames, int numberOfAttempts) {

    public static GameRequestDto from(String carNames, String numberOfAttempts) {
        validateNotBlank(carNames, "자동차 이름 목록 문자열은 비어 있으면 안됩니다");

        validateNotBlank(numberOfAttempts, "시도 횟수가 비어 있으면 안됩니다");
        int validAttempts = validateAndParseInt(numberOfAttempts, "시도 횟수는 숫자여야 합니다");

        return new GameRequestDto(carNames, validAttempts);
    }

}
