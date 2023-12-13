package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Money {

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
        return money % divisor.money == 0;
    }

    public int divideBy(Money divisor) {
        return money / divisor.money;
    }

    public double calculateRateOfReturn(Money totalWinningPrize) {
        double rateOfReturn = (totalWinningPrize.money / (double) this.money) * 100;
        BigDecimal halfUpRateOfReturn = new BigDecimal(Double.toString(rateOfReturn));
        return halfUpRateOfReturn.setScale(1, RoundingMode.HALF_UP).doubleValue();
    }

    public int getMoney() {
        return money;
    }
}
