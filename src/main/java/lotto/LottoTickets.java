package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private List<LottoTicket> lottoTickets = new ArrayList<>();
    private int numberOfManuallyPurchasedLottoTicket;

    public void addLottoTicket(LottoTicket lottoTicket) {
        this.lottoTickets.add(lottoTicket);
    }

    public void addAllManuallyPurchasedLottoTickets(LottoTickets manuallyPurchasedLottoTickets) {
        List<LottoTicket> listOfManuallyPurchasedLottoTicket = manuallyPurchasedLottoTickets.lottoTickets;

        for (LottoTicket lottoTicket : listOfManuallyPurchasedLottoTicket) {
            addLottoTicket(lottoTicket);
        }

        this.numberOfManuallyPurchasedLottoTicket += listOfManuallyPurchasedLottoTicket.size();
    }

    public int getNumberOfManuallyPurchasedLottoTicket() {
        return this.numberOfManuallyPurchasedLottoTicket;
    }

    public int getNumberOfAutomaticallyPurchasedLottoTicket() {
        return this.lottoTickets.size() - this.numberOfManuallyPurchasedLottoTicket;
    }

    public LottoResults getLottoResults(LottoWinningNumber lottoWinningNumber) {
        LottoResults lottoResults = new LottoResults();
        LottoResultDetector lottoResultDetector = new LottoResultDetector();

        for (LottoTicket lottoTicket : lottoTickets) {
            LottoResult lottoResult = lottoResultDetector.getLottoResult(lottoTicket, lottoWinningNumber);
            lottoResults.addLottoResult(lottoResult);
        }

        return lottoResults;
    }

    public String printAllLottoNumbers() {
        StringBuilder stringBuilder = new StringBuilder();

        for (LottoTicket lottoTicket : this.lottoTickets) {
            stringBuilder.append(lottoTicket)
                    .append("\n");
        }

        return stringBuilder.toString();
    }
}
