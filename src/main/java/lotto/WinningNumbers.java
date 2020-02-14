package lotto;

import java.util.LinkedHashSet;
import java.util.Set;

public class WinningNumbers {

    private Set<LottoNumber> winningNumbers = new LinkedHashSet<>();
    private LottoNumber bonusNumber;

    public WinningNumbers(Set<LottoNumber> selectedWinningNumbers, LottoNumber bonusNumber) {
        for (LottoNumber selectedWinningNumbuer : selectedWinningNumbers) {
            selectedWinningNumbers.add(selectedWinningNumbuer);
            this.winningNumbers.add(selectedWinningNumbuer);
        }

        this.bonusNumber = bonusNumber;
        checkIsDuplicatedNumberWithBonusNumber();
    }

    private void checkIsDuplicatedNumberWithBonusNumber() {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 중복될 수 없습니다.");
        }

        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호는 중복될 수 없습니다.");
        }
    }

    public Set<LottoNumber> getWinningNumbers() {
        return winningNumbers;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
