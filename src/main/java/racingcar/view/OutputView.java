package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {
    private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";
    private static final String NAME_RESULT_SEPARATOR = " : ";
    private static final String POSITION_SYMBOL = "-";


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
}
