package lotto.view;

import java.util.List;

public class OutputView {

    private OutputView() {

    }

    public static void printIssuedLottos(List<String> issuedLottosInformation) {
        System.out.println();
        System.out.println(String.format("%d개를 구매했습니다.", issuedLottosInformation.size()));
        for (String lottoInformation : issuedLottosInformation) {
            System.out.println(lottoInformation);
        }
    }
}
