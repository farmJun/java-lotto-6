package lotto.view;

import java.util.List;
import java.util.Map.Entry;
import lotto.domain.Rank;
import lotto.domain.Statistics;

public class OutputView {

    private static final String NUMBER_OF_LOTTO_PURCHASED_MESSAGE = "%d개를 구매했습니다.";
    private static final String STATISTICS_FOREWORD_MESSAGE = "당첨통계";
    private static final String TRIPLE_DASH = "---";
    private static final String MESSAGE_WITHOUT_BONUS_NUMBER = "%d개 일치 (%,d원) - %d개";
    private static final String MESSAGE_WITH_BONUS_NUMBER = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개";
    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %.1f%%입니다.";


    private OutputView() {

    }

    public static void printIssuedLottos(List<String> issuedLottosInformation) {
        System.out.println();
        System.out.println(
            String.format(NUMBER_OF_LOTTO_PURCHASED_MESSAGE, issuedLottosInformation.size()));
        for (String lottoInformation : issuedLottosInformation) {
            System.out.println(lottoInformation);
        }
    }

    public static void printStatistics(Statistics statistics) {
        System.out.println(STATISTICS_FOREWORD_MESSAGE);
        System.out.println(TRIPLE_DASH);

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
        System.out.println(String.format(RATE_OF_RETURN_MESSAGE, profit));
    }

    public static void printExceptionMessage(IllegalArgumentException illegalArgumentException) {
        System.out.println(illegalArgumentException.getMessage());
    }
}
