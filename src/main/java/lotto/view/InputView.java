package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private InputView() {

    }

    public static int readMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return readNumber();
    }

    public static void readWinningNumbers() {

    }

    public static int readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return readNumber();
    }

    private static int readNumber() {
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}
