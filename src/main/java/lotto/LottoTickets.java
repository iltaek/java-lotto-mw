package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private List<LottoTicket> lottoTickets = new ArrayList<>();

    public void addLottoTicket(LottoTicket lottoTicket) {
        this.lottoTickets.add(lottoTicket);
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

    public int numberOfLottoTicketPurchased() {
        return this.lottoTickets.size();
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
