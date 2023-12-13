package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final String INPUT_LOTTO_PURCHASE_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_LOTTO_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String SEPARATOR = ",";
    private static final String ERROR_MESSAGE_HEADER = "[ERROR] ";
    private static final String NUMBER_REGEX_PATTERN = "\\d+";

    private InputView() {

    }

    public static int readMoney() {
        System.out.println(INPUT_LOTTO_PURCHASE_MONEY_MESSAGE);
        return readNumber();
    }

    public static List<Integer> readWinningNumbers() {
        System.out.println(INPUT_LOTTO_WINNING_NUMBERS_MESSAGE);
        String input = Console.readLine();

        return Arrays.stream(input.split(SEPARATOR))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    public static int readBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        return readNumber();
    }

    private static int readNumber() {
        String input = Console.readLine();
        validate(input);
        return Integer.parseInt(input);
    }

    private static void validate(String input) {
        if (!input.matches(NUMBER_REGEX_PATTERN)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_HEADER);
        }
    }
}
