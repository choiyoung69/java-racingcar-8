package racingcar.domain;

import static racingcar.util.ValidationUtils.validateNotBlank;

import racingcar.domain.strategy.MoveStrategy;

public class Car {
    private final String name;
    private int distance;
    private MoveStrategy moveStrategy;

    private Car(String name, int distance, MoveStrategy moveStrategy){
        validateCarNameFormat(name);
        this.name = name;
        this.distance = distance;
        this.moveStrategy = moveStrategy;
    }

    private void validateCarNameFormat(String name) {
        validateNotBlank(name, "자동차 이름은 비어있으면 안됩니다.");
        if(name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다" + name);
        }
    }

    public static Car from(String name, int distance, MoveStrategy moveStrategy){
        return new Car(name, distance, moveStrategy);
    }

    public void decideToMove() {
        if(moveStrategy.isAllowedToAdvance()) distance++;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
