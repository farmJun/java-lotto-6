package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Money {

    private static final int ZERO = 0;
    private static final int ONE_HUNDRED_PERCENT = 100;
    private static final int SCALE = 1;
    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        if (money < 0) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isDivideUpBy(Money divisor) {
        return money % divisor.money == ZERO;
    }

    public int divideBy(Money divisor) {
        return money / divisor.money;
    }

    public double calculateRateOfReturn(Money totalWinningPrize) {
        double rateOfReturn = (totalWinningPrize.money / (double) this.money) * ONE_HUNDRED_PERCENT;
        BigDecimal halfUpRateOfReturn = new BigDecimal(Double.toString(rateOfReturn));
        return halfUpRateOfReturn.setScale(SCALE, RoundingMode.HALF_UP).doubleValue();
    }

    public int getMoney() {
        return money;
    }
}
