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

        Iterator<LottoNumber> lottoNumberIterator = winningLottoNumbers.iterator();

        // 당첨 번호 = 1 가산점
        for (int i = 0; i < winningLottoNumbers.size() - 1; i++) {
            matchingCounts += match(lottoNumberIterator.next(), 1);
        }

        // 보너스 당첨 번호 = 10 가산점
        matchingCounts += match(lottoNumberIterator.next(), 10);

        return Prize.of(matchingCounts);
    }

    private int match(LottoNumber winningNumber, int score) {
        if (markedLottoNumbers.contains(winningNumber)) {
            return score;
        }
        return 0;
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
