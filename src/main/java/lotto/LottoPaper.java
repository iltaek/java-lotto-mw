package lotto;

import java.util.LinkedHashSet;
import java.util.Iterator;
import java.util.Set;

public class LottoPaper {

    private Set<LottoNumber> markedLottoNumbers = new LinkedHashSet<>();

    public LottoPaper(Set<LottoNumber> markedLottoNumbers) {
        for (LottoNumber markedLottoNumber : markedLottoNumbers) {
            markedLottoNumbers.add(markedLottoNumber);
            this.markedLottoNumbers.add(markedLottoNumber);
        }

        checkIsDuplicatedNumber();
    }


    public Set<LottoNumber> getMarkedLottoNumbers() {
        return markedLottoNumbers;
    }

    private void checkIsDuplicatedNumber() {
        if (markedLottoNumbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    public Prize matchingCountsLottoNumbers(WinningNumbers winningNumbers) {
        int matchingCounts = 0;
        Set<LottoNumber> winningLottoNumbers = winningNumbers.getWinningNumbers();
        LottoNumber bonusNumber = winningNumbers.getBonusNumber();

        for (LottoNumber winningNumber : winningLottoNumbers) {
            if ( markedLottoNumbers.contains(winningNumber)) {
                matchingCounts++;
            }
        }

        if ( matchingCounts == 5) {
            if (markedLottoNumbers.contains(bonusNumber)) {
                return Prize.SECOND_PRIZE;
            }
        }
        for ( Prize prize : Prize.values()) {
            if ( prize.required() == matchingCounts) {
                return prize;
            }
        }

        return Prize.LOSE_PRIZE;
    }

    @Override
    public String toString() {
        String resultString = "";
        Iterator<LottoNumber> lottoNumberIterator = markedLottoNumbers.iterator();
        while (lottoNumberIterator.hasNext()) {
            resultString += lottoNumberIterator.next() + ",";
        }
        return resultString.substring(0, resultString.length() - 1);
    }
}
