package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, false, new Money(2_000_000_000)),
    SECOND(5, true, new Money(30_000_000)),
    THIRD(5, false, new Money(1_500_000)),
    FOURTH(4, false, new Money(50_000)),
    FIFTH(3, false, new Money(5_000)),
    NOTHING(0, false, new Money(0));

    private int matchCount;
    private boolean hasBonusNumber;
    private Money prize;

    Rank(int matchCount, boolean hasBonusNumber, Money prize) {
        this.matchCount = matchCount;
        this.hasBonusNumber = hasBonusNumber;
        this.prize = prize;
    }

    public static Rank findRank(int matchCount, boolean hasBonusNumber) {
        return Arrays.stream(Rank.values())
            .filter(rank -> rank.hasSameMatchCount(matchCount))
            .filter(rank -> rank.weatherHasBonusNumberIsSame(hasBonusNumber))
            .findFirst()
            .orElse(NOTHING);
    }

    private boolean hasSameMatchCount(int matchCount) {
        return this.matchCount == matchCount;
    }

    private boolean weatherHasBonusNumberIsSame(boolean hasBonusNumber) {
        return this.hasBonusNumber == hasBonusNumber;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public Money getPrize() {
        return prize;
    }
}
