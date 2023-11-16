package baseball;

import java.util.Set;

public class Application {
    public static void main(String[] args) {
        try {
            OutputView.inputNumber();
            final Set<Integer> input = InputView.input();
            final RandomGenerator randomGenerator = new RandomGenerator();

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
