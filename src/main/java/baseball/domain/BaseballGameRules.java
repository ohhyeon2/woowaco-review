package baseball.domain;

import java.util.List;

public enum BaseballGameRules {
    STRIKE("스트라이크", 0),
    BALL("볼", 0),
    NOTHING("낫싱");

    private final String rules;
    private int count;

    BaseballGameRules(String rules, int count) {
        this.rules = rules;
        this.count = count;
    }
    BaseballGameRules(String rules) {
        this.rules = rules;
    }

    public static void countInit() {
        STRIKE.count = 0;
        BALL.count = 0;
    }

    public static void baseballCount(List<Integer> input, List<Integer> randomNumbers) {
        BaseballGameRules.countInit();
        for (int i = 0; i < 3; i++) {
            if (randomNumbers.get(i).equals(input.get(i))) {
                STRIKE.count++;
            }
            if (randomNumbers.contains(input.get(i)) && !randomNumbers.get(i).equals(input.get(i))) {
                BALL.count++;
            }
        }
    }

    public static String getBaseballCount() {
        StringBuilder sb = new StringBuilder();
        if (STRIKE.count == 0 && BALL.count == 0) {
            return sb.append(NOTHING.rules).toString();
        }
        if (BALL.count != 0) {
            sb.append(BALL.count).append(BALL.rules);
        }
        if (STRIKE.count != 0) {
            sb.append(STRIKE.count).append(STRIKE.rules);
        }
        return sb.toString();
    }

    public static boolean isThreeStrike() {
        return STRIKE.count == 3;
    }
}
