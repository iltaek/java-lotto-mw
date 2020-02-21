package lotto;

public class LottoMain {
    public static void main(String[] args) {
        new LottoMain().run(new LottoUserInputReceiver(), new LottoOutputPrinter());
    }

    private void run(LottoUserInputReceiver lottoUserInputReceiver, LottoOutputPrinter lottoOutputPrinter) {
        LottoUserInput lottoUserInput = lottoUserInputReceiver.receiveLottoPurchaseInformation();
        LottoTickets purchasedLottoTickets = lottoUserInput.getResultOfPurchase();
        lottoOutputPrinter.printResultOfPurchase(purchasedLottoTickets);

        lottoUserInput = lottoUserInputReceiver.receiveLottoWinningNumberInformation();
        LottoResults lottoResults = lottoUserInput.getLottoResults(purchasedLottoTickets);
        lottoOutputPrinter.printResultOfStatistics(lottoResults);
    }
}
