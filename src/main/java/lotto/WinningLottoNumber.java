package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLottoNumber {
    private final List<LottoNumber> winnerLottoNumbers;
    private final LottoNumber bonusNumber;

    public WinningLottoNumber(List<LottoNumber> winningLottoNumbers, LottoNumber bonusNumber) {
        checkValidation(winningLottoNumbers, bonusNumber);

        this.winnerLottoNumbers = winningLottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void checkValidation(List<LottoNumber> winningLottoNumbers, LottoNumber bonusNumber) {
        if (winningLottoNumbers == null || winningLottoNumbers.size() != LottoStaticConstants.LOTTO_TICKET_NUMBER_SIZE) {
            throw new IllegalArgumentException(LottoStaticConstants.LOTTO_TICKET_NUMBER_SIZE_ERROR_MESSAGE);
        }

        Set<LottoNumber> winningLottoNumbersWithoutDuplicates = new HashSet<>(winningLottoNumbers);
        if (winningLottoNumbersWithoutDuplicates.size() != LottoStaticConstants.LOTTO_TICKET_NUMBER_SIZE) {
            throw new IllegalArgumentException(LottoStaticConstants.LOTTO_TICKET_NUMBER_SIZE_ERROR_MESSAGE);
        }

        if (bonusNumber == null) {
            throw new IllegalArgumentException(LottoStaticConstants.LOTTO_BONUS_NUMBER_EMPTY_ERROR_MESSAGE);
        }

        if (winningLottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(LottoStaticConstants.LOTTO_BONUS_NUMBER_DUPLICATED_ERROR_MESSAGE);
        }
    }

    public int countMatchingNumbers(List<LottoNumber> candidateLottoNumbers) {
        return (int) candidateLottoNumbers.stream()
                .filter(winnerLottoNumbers:: contains)
                .count();
    }

    public boolean doesContainBonusNumber(List<LottoNumber> candidateLottoNumbers) {
        return candidateLottoNumbers.contains(bonusNumber);
    }
}
