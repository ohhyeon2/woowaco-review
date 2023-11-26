package baseball.domain;

import camp.nextstep.edu.missionutils.Console;

public enum BaseballGameRetry {
    RETRY("1"),
    QUIT("2");

    private final String button;

    BaseballGameRetry(String button) {
        this.button = button;
    }

    public boolean isRetryGame(String input) {
        return button.equals(input);
    }
}
