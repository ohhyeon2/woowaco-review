package baseball.view;

import static baseball.view.ViewConstant.INPUT_NUMBER_FORMAT_EXCEPTION;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputView {

    public static List<Integer> input() {
        final String input = Console.readLine();
        validateInput(input, inputParsing(input));
        return inputParsing(input);
    }

    private static List<Integer> inputParsing(final String input) {
        List<Integer> nums = new ArrayList<>();
        for (String num : input.split("")) {
            nums.add(validateNumber(num));
        }
        return nums;
    }

    private static int validateNumber(final String num) {
        try {
            return Integer.parseInt(num);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(INPUT_NUMBER_FORMAT_EXCEPTION);
        }
    }

    private static void validateInput(final String input, final List<Integer> nums) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(INPUT_NUMBER_FORMAT_EXCEPTION);
        }
        if (input.length() != 3) {
            throw new IllegalArgumentException(INPUT_NUMBER_FORMAT_EXCEPTION);
        }
        Set<Integer> duplicate = new HashSet<>(nums);
        if (duplicate.size() != input.length()) {
            throw new IllegalArgumentException(INPUT_NUMBER_FORMAT_EXCEPTION);
        }
    }
}
