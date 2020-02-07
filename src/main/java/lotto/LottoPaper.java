package lotto;

import java.util.List;

public class LottoPaper {

    private boolean isAutoSelected;
    private List<LottoNumber> markedLottoNumbers;

    public LottoPaper(boolean isAutoSelected, List<LottoNumber> markedLottoNumbers) {
        this.isAutoSelected = isAutoSelected;
        for ( LottoNumber :markedLottoNumbers)
        this.markedLottoNumbers = markedLottoNumbers;

    }

    public boolean isAutoSelected(){
        return isAutoSelected;
    }

    public LottoNumber[] getMarkedLottoNumbers() {
        return markedLottoNumbers;
    }
}
