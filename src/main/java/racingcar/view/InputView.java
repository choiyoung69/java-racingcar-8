package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TOTAL_ROUNDS_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public static GameRequestDto readGameRequest() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        String carNames = Console.readLine();
        System.out.println(INPUT_TOTAL_ROUNDS_MESSAGE);
        String numberOfAttempts = Console.readLine();

        return GameRequestDto(carNames, numberOfAttempts);
    }
}
