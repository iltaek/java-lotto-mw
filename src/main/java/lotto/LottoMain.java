package lotto;

public class LottoMain {
    public static void main(String[] args) {
        LottoUserInputReceiver lottoUserInputReceiver = new LottoUserInputReceiver();
        LottoUserInput lottoUserInput = lottoUserInputReceiver.receiveLottoPurchaseInformation();

        int numberOfPurchasedLottoTicket = lottoUserInput.getNumberOfPurchasedLottoTicket();
        int numberOfManuallyPurchasedLottoTicket = lottoUserInput.getNumberOfManuallyPurchasedLottoTicket();

        LottoTickets purchasedLottoTickets = new LottoTickets();
        LottoTickets manuallyPurchasedLottoTickets = lottoUserInput.getManuallyPurchasedLottoTickets();
        purchasedLottoTickets.addAllLottoTickets(manuallyPurchasedLottoTickets);

        int numberOfAutomaticallyPurchasedLottoTicket = numberOfPurchasedLottoTicket - numberOfManuallyPurchasedLottoTicket;
        LottoMachine lottoMachine = new LottoMachine();
        for (int i = 0; i < numberOfAutomaticallyPurchasedLottoTicket; i++) {
            purchasedLottoTickets.addLottoTicket(lottoMachine.generateLottoTicketAutomatically());
        }

        LottoOutputPrinter lottoOutputPrinter = new LottoOutputPrinter();
        lottoOutputPrinter.printResultOfPurchase(purchasedLottoTickets, numberOfManuallyPurchasedLottoTicket);

        lottoUserInput = lottoUserInputReceiver.receiveLottoWinningNumberInformation();

        LottoWinningNumber lottoWinningNumber = lottoUserInput.getLottoWinningNumber();
        LottoResults lottoResults = purchasedLottoTickets.getLottoResults(lottoWinningNumber);

        lottoOutputPrinter.printResultOfStatistics(lottoResults);
    }
}
