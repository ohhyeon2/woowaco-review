package baseball.domain;

import java.util.HashMap;
import java.util.Map;

public enum Retry {
    RETRY("1", true),
    QUIT("2", false);

    private final String button;
    private final boolean restartOrQuit;

    Retry(String button, boolean restartOrQuit) {
        this.button = button;
        this.restartOrQuit = restartOrQuit;
    }

    private static Map<String, Boolean> restartAndQuitOption() {
        Map<String, Boolean> options = new HashMap<>();
        for (Retry option : Retry.values()) {
            options.put(option.button, option.restartOrQuit);
        }
        return options;
    }

    public static boolean restartAndQuit(String input) {
        Map<String, Boolean> options = restartAndQuitOption();
        return options.get(input);
    }
}
