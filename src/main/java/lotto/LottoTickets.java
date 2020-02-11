package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private List<LottoTicket> lottoTickets = new ArrayList<>();

    public void addLottoTicket(LottoTicket lottoTicket) {
        this.lottoTickets.add(lottoTicket);
    }
}
