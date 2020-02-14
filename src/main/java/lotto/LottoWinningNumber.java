package lotto;

import java.util.List;

public class LottoWinningNumber {
    private final LottoTicket lottoWinningTicket;
    private final LottoNumber bonusNumber;

    public LottoWinningNumber(LottoTicket lottoWinningTicket, LottoNumber bonusNumber) {
        checkValidation(lottoWinningTicket, bonusNumber);

        this.lottoWinningTicket = lottoWinningTicket;
        this.bonusNumber = bonusNumber;
    }

    private void checkValidation(LottoTicket winningLottoTicket, LottoNumber bonusNumber) {
        if (winningLottoTicket == null) {
            throw new IllegalArgumentException(LottoStaticConstants.LOTTO_TICKET_NUMBER_SIZE_ERROR_MESSAGE);
        }

        if (bonusNumber == null) {
            throw new IllegalArgumentException(LottoStaticConstants.LOTTO_BONUS_NUMBER_EMPTY_ERROR_MESSAGE);
        }

        if (winningLottoTicket.contains(bonusNumber)) {
            throw new IllegalArgumentException(LottoStaticConstants.LOTTO_BONUS_NUMBER_DUPLICATED_ERROR_MESSAGE);
        }
    }

    public int countMatchingNumbers(List<LottoNumber> candidateLottoNumbers) {
        return (int) candidateLottoNumbers.stream()
                .filter(lottoWinningTicket:: contains)
                .count();
    }

    public boolean doesContainBonusNumber(List<LottoNumber> candidateLottoNumbers) {
        return candidateLottoNumbers.contains(bonusNumber);
    }
}
