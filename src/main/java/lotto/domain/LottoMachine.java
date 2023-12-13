package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private static final Money LOTTO_PRICE = new Money(1000);

    private LottoMachine() {

    }

    public static Lottos issueLottos(Money lottoPurchaseMoney) {
        validate(lottoPurchaseMoney);
        int numberOfLottos = lottoPurchaseMoney.divideBy(LOTTO_PRICE);
        return new Lottos(issueLottos(numberOfLottos));
    }

    private static List<Lotto> issueLottos(int numberOfLottos) {
        return IntStream.range(0, numberOfLottos)
            .mapToObj(i -> new Lotto(generateRandomNumbers()))
            .collect(Collectors.toList());
    }

    private static void validate(Money lottoPurchaseMoney) {
        if (!lottoPurchaseMoney.isDivideUpBy(LOTTO_PRICE)) {
            throw new IllegalArgumentException();
        }

        if (lottoPurchaseMoney.divideBy(LOTTO_PRICE) == 0) {
            throw new IllegalArgumentException();
        }
    }

    private static List<Integer> generateRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        randomNumbers.sort(Integer::compareTo);
        return randomNumbers;
    }
}
