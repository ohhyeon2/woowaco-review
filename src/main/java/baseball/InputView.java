package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.Set;

public class InputView {

    public static Set<Integer> input() {
        String input = Console.readLine();
        Set<Integer> nums = inputParsing(input);
        validateInput(input, nums);
        return nums;
    }

    public static Set<Integer> inputParsing(String input) {
        Set<Integer> nums = new HashSet<>();
        for (String num : input.split("")) {
            nums.add(validateNumber(num));
        }
        return nums;
    }

    public static int validateNumber(String num) {
        try {
            return Integer.parseInt(num);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("error : 숫자 외에 다른 문자의 입력은 안된다.");
        }
    }

    public static void validateInput(String input, Set<Integer> nums) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("error : 세자리의 숫자를 입력해주세요.");
        }
        if (input.length() != 3) {
            throw new IllegalArgumentException("error : 세자리의 숫자를 입력해주세요.");
        }
        if (nums.size() != input.length()) {
            throw new IllegalArgumentException("error : 중복된 수는 입력할 수 없습니다.");
        }
    }
}
