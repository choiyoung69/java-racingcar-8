package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {
    private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_ANNOUNCEMENT_MESSAGE = "최종 우승자 : ";
    private static final String NAME_RESULT_SEPARATOR = " : ";
    private static final String POSITION_SYMBOL = "-";
    private static final String WINNER_DELIMITER = ", ";


    public static void printExecutionResultMessage() {
        System.out.println();
        System.out.println(EXECUTION_RESULT_MESSAGE);
    }

    public static void printRound(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getName() + NAME_RESULT_SEPARATOR + getPositionString(car.getDistance()));
        }
    }

    public static String getPositionString(int carDistance) {
        return POSITION_SYMBOL.repeat(carDistance);
    }

    public static void printWinner(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(WINNER_DELIMITER));
        System.out.println(WINNER_ANNOUNCEMENT_MESSAGE + winnerNames);
    }
}
