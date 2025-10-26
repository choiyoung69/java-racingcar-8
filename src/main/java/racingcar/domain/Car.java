package racingcar.domain;

public class Car {
    private final String name;
    private int distance;
    private MoveStrategy moveStrategy;

    private Car(String name, int distance, MoveStrategy moveStrategy){
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
}
