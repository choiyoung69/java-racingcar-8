package racingcar.domain;

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

    public static Car from(String name, int distance, MoveStrategy moveStrategy){
        return new Car(name, distance, moveStrategy);
    }

    public void decideToMove() {
        if(moveStrategy.isAllowedToAdvance()) distance++;
    }

    private void validateCarNameFormat(String name) {
        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 비어있으면 안됩니다.");
        }
        if(name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름이 5글자 이상입니다" + name);
        }
    }
}
