package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomGenerator {

    private final List<Integer> randomNumbers;

    public RandomGenerator() {
        this.randomNumbers = randomNumber();
    }

    private List<Integer> randomNumber() {
        final List<Integer> numbers = new ArrayList<>();
        while (numbers.size() != 3) {
            numbers.add(randomGenerator(numbers));
        }
        return numbers;
    }

    private int randomGenerator(final List<Integer> numbers) {
        final int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (numbers.contains(randomNumber)) {
            return randomGenerator(numbers);
        }
        return randomNumber;
    }

    public List<Integer> getNumbers() {
        return randomNumbers;
    }
}
