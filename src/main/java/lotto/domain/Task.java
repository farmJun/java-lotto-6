package lotto.domain;

import java.util.function.Function;
import java.util.function.Supplier;
import lotto.view.OutputView;

public class Task {

    public static <T, R> R retryUntilSuccess(Supplier<T> supplier, Function<T, R> function) {
        while (true) {
            try {
                T t = supplier.get();
                return function.apply(t);
            } catch (IllegalArgumentException illegalArgumentException) {
                OutputView.printExceptionMessage(illegalArgumentException);
            }
        }
    }
}
