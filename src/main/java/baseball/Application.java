package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            OutputView.inputNumber();
            final InputView inputView = new InputView();
            final RandomGenerator randomGenerator = new RandomGenerator();
            System.out.println(randomGenerator.getNumbers());
            final List<Integer> input= inputView.input();
            System.out.println(referee(input, randomGenerator));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public static boolean referee(List<Integer> input, RandomGenerator randomGenerator) {
        int strikeCount = 0;
        int ballCount = 0;

        threeStrike(input, randomGenerator);
        if (!nothing(input, randomGenerator)) {
            System.out.println("낫싱");
            return false;
        }
        if (nothing(input, randomGenerator)) {
            strikeCount = strike(input, randomGenerator);
            ballCount = ball(input, randomGenerator);
        }
        System.out.println("볼" + ballCount + ", " + "스트라이크" + strikeCount);
        return true;
    }
    public static boolean nothing(List<Integer> input, RandomGenerator randomGenerator) {
        final boolean nothing = false;
        for (Integer integer : input) {
            if (randomGenerator.getNumbers().contains(integer)) {
                return true;
            }
        }
        return nothing;
    }
    public static int strike(List<Integer> input, RandomGenerator randomGenerator) {
        int strikeCount = 0;
        for (int i = 0; i < randomGenerator.getNumbers().size(); i++) {
            if (randomGenerator.getNumbers().get(i).equals(input.get(i))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public static int ball(List<Integer> input, RandomGenerator randomGenerator) {
        int ballCount = 0;
        for (int i = 0; i < randomGenerator.getNumbers().size(); i++) {
            if (randomGenerator.getNumbers().contains(input.get(i)) && !randomGenerator.getNumbers().get(i).equals(input.get(i)))
                ballCount++;
        }
        return ballCount;
    }

    public static void threeStrike(List<Integer> input, RandomGenerator randomGenerator) {
        if (randomGenerator.getNumbers().containsAll(input)) {
            System.out.println("3스트라이크 게임 종료");
        }
    }
}
