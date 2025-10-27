package racingcar.dto;

public record GameRequestDto(String carNames, int numberOfAttempts) {
    public static GameRequestDto from(String carNames, String numberOfAttempts) {
        validateCarNames(carNames);
        int validAttempts = toValidAttempts(numberOfAttempts);
        return new GameRequestDto(carNames, validAttempts);
    }

    private static void validateCarNames(String carNames) {
        if (carNames == null || carNames.isBlank()) {
            throw new IllegalArgumentException("자동차 이름 목록 문자열은 비어 있으면 안됩니다");
        }
    }

    private static int toValidAttempts(String numberOfAttempts) {
        if (numberOfAttempts == null || numberOfAttempts.isBlank()) {
            throw new IllegalArgumentException("시도 횟수를 입력해야 합니다.");
        }

        try {
            return Integer.parseInt(numberOfAttempts);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다");
        }
    }
}
