package baseball;

public class Application {
    public static void main(String[] args) {
        try {
            OutputView.inputNumber();
            final InputView input = new InputView();
            final RandomGenerator randomGenerator = new RandomGenerator();

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
