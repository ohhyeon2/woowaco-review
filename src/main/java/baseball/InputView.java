package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.Set;

public class InputView {

    public static Set<Integer> input() {
        final String input = Console.readLine();
        final Set<Integer> nums = inputParsing(input);
        validateInput(input, nums);
        return nums;
    }

    private static Set<Integer> inputParsing(final String input) {
        final Set<Integer> nums = new HashSet<>();
        for (final String num : input.split("")) {
            nums.add(validateNumber(num));
        }
        return nums;
    }

    private static int validateNumber(final String num) {
        try {
            return Integer.parseInt(num);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("error : 세자리의 숫자만 입력해주세요.");
        }
    }

    private static void validateInput(final String input, final Set<Integer> nums) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("error : 세자리의 숫자만 입력해주세요.");
        }
        if (input.length() != 3) {
            throw new IllegalArgumentException("error : 세자리의 숫자만 입력해주세요.");
        }
        if (nums.size() != input.length()) {
            throw new IllegalArgumentException("error : 중복된 수는 입력할 수 없습니다.");
        }
    }
}
