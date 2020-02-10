package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoPaper {

    private boolean isAutoSelected;
    private List<LottoNumber> markedLottoNumbers = new ArrayList<>();
    private List<Integer> checkedNumbers = new ArrayList<>();

    public LottoPaper(boolean isAutoSelected, List<LottoNumber> markedLottoNumbers) {
        this.isAutoSelected = isAutoSelected;
        for (LottoNumber markedLottoNumber : markedLottoNumbers) {
            checkIsDuplicatedNumber(markedLottoNumber);
            this.checkedNumbers.add(markedLottoNumber.selectedNumber);
            this.markedLottoNumbers.add(markedLottoNumber);
        }

    }

    public boolean isAutoSelected() {
        return isAutoSelected;
    }

    public List<LottoNumber> getMarkedLottoNumbers() {
        return markedLottoNumbers;
    }

    private void checkIsDuplicatedNumber(LottoNumber current) {
        if (checkedNumbers.contains(current.selectedNumber)) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    public String toString() {
        String resultString = "";
        for (int i = 0; i < 6; i++) {
            resultString += markedLottoNumbers.get(i).selectedNumber + ",";
        }
        return resultString.substring(0, resultString.length() - 1);
    }
}
