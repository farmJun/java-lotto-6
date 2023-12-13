package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

public class Referee {

    private static final int ZERO = 0;
    private static final int INCREASE = 1;

    private Referee() {

    }

    public static Statistics judge(
        Lottos issuedLottos,
        Lotto winningLotto,
        LottoNumber bonusNumber) {

        EnumMap<Rank, Integer> statistics = initialStatistics();

        List<Rank> ranks = issuedLottos.calculateRankOfLottos(winningLotto, bonusNumber);

        for (Rank rank : ranks) {
            statistics.put(rank, statistics.get(rank) + INCREASE);
        }

        return new Statistics(statistics);
    }

    private static EnumMap<Rank, Integer> initialStatistics() {
        EnumMap<Rank, Integer> initialStatistics = new EnumMap<>(Rank.class);

        Arrays.stream(Rank.values())
            .forEach(rank -> initialStatistics.put(rank, ZERO));

        return initialStatistics;
    }
}
