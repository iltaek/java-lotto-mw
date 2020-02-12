package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoResults {
    private List<LottoResult> lottoResults = new ArrayList<>();

    public void addLottoResult(LottoResult lottoResult) {
        this.lottoResults.add(lottoResult);
    }
}
