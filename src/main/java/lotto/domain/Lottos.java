package lotto.domain;

import java.util.ArrayList;
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

    public List<Rank> calculateRankOfLottos(Lotto winningLotto, LottoNumber bonusNumber) {
        List<Rank> ranks = new ArrayList<>();

        for (Lotto lotto : lottos) {
            int matchCount = lotto.countMatchWith(winningLotto);
            boolean hasBonusNumber = lotto.hasNumber(bonusNumber);
            Rank rank = Rank.findRank(matchCount, hasBonusNumber);

            ranks.add(rank);
        }

        return ranks;
    }
}
