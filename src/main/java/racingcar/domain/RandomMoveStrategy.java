package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int RANDOM_START_NUMBER = 0;
    private static final int RANDOM_END_NUMBER = 9;
    private static final int MOVE_THRESHOLD = 4;

    private static final RandomMoveStrategy INSTANCE = new RandomMoveStrategy();

    private RandomMoveStrategy() {
    }

    public static RandomMoveStrategy getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean isAllowedToAdvance() {
        return Randoms.pickNumberInRange(
                RANDOM_START_NUMBER,
                RANDOM_END_NUMBER) >= MOVE_THRESHOLD;
    }
}
