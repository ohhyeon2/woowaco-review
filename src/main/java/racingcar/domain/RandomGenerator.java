package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {

    public static int randomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
