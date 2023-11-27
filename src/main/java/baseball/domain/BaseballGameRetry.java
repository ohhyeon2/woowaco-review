package baseball.domain;

import java.util.HashMap;
import java.util.Map;

public enum BaseballGameRetry {
    RETRY("1", true),
    QUIT("2", false);

    private final String button;
    private final boolean restartOrQuit;

    BaseballGameRetry(String button, boolean restartOrQuit) {
        this.button = button;
        this.restartOrQuit = restartOrQuit;
    }

    private static Map<String, Boolean> restartAndQuitOption() {
        Map<String, Boolean> options = new HashMap<>();
        for (BaseballGameRetry option : BaseballGameRetry.values()) {
            options.put(option.button, option.restartOrQuit);
        }
        return options;
    }

    public static boolean restartAndQuit(String input) {
        Map<String, Boolean> options = restartAndQuitOption();
        return options.get(input);
    }
}
