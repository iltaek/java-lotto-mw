package lotto;

import java.util.LinkedHashSet;
import java.util.Set;

public class WinningNumbers {

    private Set<LottoNumber> winningNumbers = new LinkedHashSet<>();

    public WinningNumbers(Set<LottoNumber> selectedWinningNumbers) {
        for (LottoNumber selectedWinningNumbuer : selectedWinningNumbers) {
            selectedWinningNumbers.add(selectedWinningNumbuer);
            this.winningNumbers.add(selectedWinningNumbuer);
        }

        checkIsDuplicatedNumber();
    }

    private void checkIsDuplicatedNumber() {
        if (winningNumbers.size() != 7) {
            throw new IllegalArgumentException("당첨 번호는 중복될 수 없습니다.");
        }
    }

    public Set<LottoNumber> getWinningNumbers() {
        return winningNumbers;
    }
}
