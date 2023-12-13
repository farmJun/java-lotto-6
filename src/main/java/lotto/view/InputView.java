package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private InputView() {

    }

    public static int readMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return readNumber();
    }

    public static List<Integer> readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();

        return Arrays.stream(input.split(","))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    public static int readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return readNumber();
    }

    private static int readNumber() {
        String input = Console.readLine();
        validate(input);
        return Integer.parseInt(input);
    }

    private static void validate(String input) {
        if(!input.matches("\\d+")){
            throw new IllegalArgumentException("[ERROR] 숫자만 입");
        }
    }
}
