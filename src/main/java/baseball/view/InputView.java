package baseball.view;

import static baseball.view.ViewConstant.INPUT_NUMBER_FORMAT_EXCEPTION;
import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputView {

    public static List<Integer> input() {
        final String input = readLine();
        final List<Integer> nums = new ArrayList<>();
        validateInput(input);
        for (String num : input.split("")) {
            validateNumberRange(num);
            nums.add(validateInputFormat(num));
        }
        return nums;
    }

    public static String inputRetry() {
        return readLine();
    }

    private static void validateInput(final String input) {
        validateInputLength(input);
        validateDuplicate(input);
    }

    private static int validateInputFormat(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(INPUT_NUMBER_FORMAT_EXCEPTION);
        }
    }

    private static void validateInputLength(final String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(INPUT_NUMBER_FORMAT_EXCEPTION);
        }
        if (input.length() != 3) {
            throw new IllegalArgumentException(INPUT_NUMBER_FORMAT_EXCEPTION);
        }
    }

    private static void validateNumberRange(final String input) {
        if (Integer.parseInt(input) < 0 || Integer.parseInt(input) > 9) {
            throw new IllegalArgumentException("숫자의 범위는 1, 9까지 입니다.");
        }

    }

    private static void validateDuplicate(final String input) {
        Set<String> duplicate = new HashSet<>(List.of(input));
        if (duplicate.size() != input.length()) {
            throw new IllegalArgumentException(INPUT_NUMBER_FORMAT_EXCEPTION);
        }
    }
}
