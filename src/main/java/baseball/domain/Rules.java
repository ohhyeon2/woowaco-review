package baseball.domain;

import java.util.List;

public class Rules {

    private static int strikeCount;
    private static int ballCount;

    public Rules(List<Integer> input, List<Integer> randomNumbers) {
        strikeCount = strikeCount(input, randomNumbers);
        ballCount = ballCount(input, randomNumbers);
    }

    private int strikeCount(List<Integer> input, List<Integer> randomNumbers) {
        int strikeCount = 0;
        for (int i = 0; i < 3; i++) {
            if (randomNumbers.get(i).equals(input.get(i))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private int ballCount(List<Integer> input, List<Integer> randomNumbers) {
        int ballCount = 0;
        for (int i = 0; i < 3; i++) {
            if (randomNumbers.contains(input.get(i)) && !randomNumbers.get(i).equals(input.get(i))) {
                ballCount++;
            }
        }
        return ballCount;
    }

    public int getStrike() {
        return strikeCount;
    }

    public int getBall() {
        return ballCount;
    }

    public static boolean isThreeStrike() {
        return strikeCount == 3;
    }
}
