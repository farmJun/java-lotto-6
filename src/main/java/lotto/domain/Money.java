package lotto.domain;

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
}
