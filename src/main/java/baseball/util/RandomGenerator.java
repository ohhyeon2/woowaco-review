package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomGenerator {

    public static List<Integer> createRandomNumbers() {
        final List<Integer> numbers = new ArrayList<>();
        while (numbers.size() != 3) {
            numbers.add(randomGenerator(numbers));
        }
        return numbers;
    }

    private static int randomGenerator(final List<Integer> numbers) {
        final int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (numbers.contains(randomNumber)) {
            return randomGenerator(numbers);
        }
        return randomNumber;
    }
}
