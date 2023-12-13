package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<String> getLottosInformation() {
        return lottos.stream()
            .map(lotto -> lotto.getNumbers())
            .collect(Collectors.toList());
    }
}
