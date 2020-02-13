package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoWinningNumber {
    private final List<LottoNumber> winnerLottoNumbers;
    private final LottoNumber bonusNumber;

    public LottoWinningNumber(List<LottoNumber> lottoWinningNumbers, LottoNumber bonusNumber) {
        checkValidation(lottoWinningNumbers, bonusNumber);

        this.winnerLottoNumbers = lottoWinningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void checkValidation(List<LottoNumber> lottoWinningNumbers, LottoNumber bonusNumber) {
        if (lottoWinningNumbers == null || lottoWinningNumbers.size() != LottoStaticConstants.LOTTO_TICKET_NUMBER_SIZE) {
            throw new IllegalArgumentException(LottoStaticConstants.LOTTO_TICKET_NUMBER_SIZE_ERROR_MESSAGE);
        }

        Set<LottoNumber> lottoWinningNumbersWithoutDuplicates = new HashSet<>(lottoWinningNumbers);
        if (lottoWinningNumbersWithoutDuplicates.size() != LottoStaticConstants.LOTTO_TICKET_NUMBER_SIZE) {
            throw new IllegalArgumentException(LottoStaticConstants.LOTTO_TICKET_NUMBER_SIZE_ERROR_MESSAGE);
        }

        if (bonusNumber == null) {
            throw new IllegalArgumentException(LottoStaticConstants.LOTTO_BONUS_NUMBER_EMPTY_ERROR_MESSAGE);
        }

        if (lottoWinningNumbers.contains(bonusNumber)) {
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
