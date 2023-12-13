package lotto.controller;

import static lotto.view.OutputView.printStatistics;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Referee;
import lotto.domain.Statistics;
import lotto.domain.Task;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {

    public void run() {
        Money lottoPurchaseMoney = readLottoPurchaseMoney();
        Lottos issuedLottos = issueLottos(lottoPurchaseMoney);
        printIssuedLottos(issuedLottos);

        Lotto winningLotto = readWinningNubmer();
        LottoNumber bonusNumber = readBonusNumber();

        Statistics statistics = Referee.judge(issuedLottos, winningLotto, bonusNumber);
        printStatistics(statistics);
        printProfit(statistics, lottoPurchaseMoney);
    }

    private Money readLottoPurchaseMoney() {
        return Task.retryUntilSuccess(InputView::readMoney, Money::new);
    }

    private Lottos issueLottos(Money lottoPurchaseMoney) {
        return LottoMachine.issueLottos(lottoPurchaseMoney);
    }

    private void printIssuedLottos(Lottos issuedLottos) {
        OutputView.printIssuedLottos(issuedLottos.getLottosInformation());
    }

    private Lotto readWinningNubmer() {
        return Task.retryUntilSuccess(InputView::readWinningNumbers, Lotto::new);
    }


    private LottoNumber readBonusNumber() {
        return Task.retryUntilSuccess(InputView::readBonusNumber, LottoNumber::from);
    }

    private void printProfit(Statistics statistics, Money lottoPurchaseMoney) {
        OutputView.printProfit(statistics.calculateProfit(lottoPurchaseMoney));
    }

    private void printStatistics(Statistics statistics) {
        OutputView.printStatistics(statistics);
    }
}
