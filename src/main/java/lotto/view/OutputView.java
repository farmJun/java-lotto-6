package lotto.view;

import java.util.List;
import java.util.Map.Entry;
import lotto.domain.Rank;
import lotto.domain.Statistics;

public class OutputView {

    private static final String MESSAGE_WITHOUT_BONUS_NUMBER = "%d개 일치 (%,d원) - %d개";
    private static final String MESSAGE_WITH_BONUS_NUMBER = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개";

    private OutputView() {

    }

    public static void printIssuedLottos(List<String> issuedLottosInformation) {
        System.out.println();
        System.out.println(String.format("%d개를 구매했습니다.", issuedLottosInformation.size()));
        for (String lottoInformation : issuedLottosInformation) {
            System.out.println(lottoInformation);
        }
    }

    public static void printStatistics(Statistics statistics) {
        for (Entry<Rank, Integer> rank : statistics.getStatistics()) {
            if (rank.getKey().equals(Rank.NOTHING)) {
                continue;
            }

            if (rank.getKey().equals(Rank.SECOND)) {
                printMessageWithBonusNumber(rank);
                continue;
            }

            printMessageWithoutBonusNumber(rank);
        }
    }

    private static void printMessageWithBonusNumber(Entry<Rank, Integer> rank) {
        System.out.println(String.format(
            MESSAGE_WITH_BONUS_NUMBER,
            rank.getKey().getMatchCount(),
            rank.getKey().getPrize().getMoney(),
            rank.getValue()
        ));
    }

    private static void printMessageWithoutBonusNumber(Entry<Rank, Integer> rank) {
        System.out.println(String.format(
            MESSAGE_WITHOUT_BONUS_NUMBER,
            rank.getKey().getMatchCount(),
            rank.getKey().getPrize().getMoney(),
            rank.getValue()
        ));
    }

    public static void printProfit(double profit) {
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", profit));
    }

    public static void printExceptionMessage(IllegalArgumentException illegalArgumentException) {
        System.out.println(illegalArgumentException.getMessage());
    }
}
