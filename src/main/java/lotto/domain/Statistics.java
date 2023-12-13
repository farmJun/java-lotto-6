package lotto.domain;

import java.util.EnumMap;
import java.util.Map.Entry;
import java.util.Set;

public class Statistics {

    private final EnumMap<Rank, Integer> statistics;

    public Statistics(EnumMap<Rank, Integer> statistics) {
        this.statistics = statistics;
    }

    public Set<Entry<Rank, Integer>> getStatistics() {
        return statistics.entrySet();
    }

    public double calculateProfit(Money lottoPucChaseMoney) {
        int money = statistics.entrySet().stream()
            .mapToInt(entry -> entry.getKey().getPrize().getMoney() * entry.getValue())
            .sum();

        Money totalWinningMoney = new Money(money);
        return lottoPucChaseMoney.calculateRateOfReturn(totalWinningMoney);
    }

}
