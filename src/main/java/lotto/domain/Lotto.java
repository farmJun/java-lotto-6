package lotto.domain;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Lotto {

    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
            .map(LottoNumber::from)
            .collect(Collectors.toList());
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

    public int countMatchWith(Lotto winningLotto) {
        return (int) numbers.stream()
            .filter(winningLotto::hasNumber)
            .count();
    }

    public boolean hasNumber(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    public String getNumbers() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        numbers.forEach(item -> joiner.add(item.toString()));
        return joiner.toString();
    }
}
