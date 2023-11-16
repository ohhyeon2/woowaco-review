package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Set;

public class RandomGenerator {

    private final Set<Integer> randomNumbers;

    public RandomGenerator() {
        this.randomNumbers = randomNumber();
    }

    private Set<Integer> randomNumber() {
        Set<Integer> ranNums = new HashSet<>();
        while (ranNums.size() != 3) {
            ranNums.add(randomGenerator());
        }
        return ranNums;
    }

    private int randomGenerator() {
        return Randoms.pickNumberInRange(1, 9);
    }

    public Set<Integer> getNumbers() {
        return randomNumbers;
    }
}
