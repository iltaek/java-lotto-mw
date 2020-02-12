package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoTicket {
    private final List<LottoNumber> lottoTicket;

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        checkValidation(lottoNumbers);

        this.lottoTicket = lottoNumbers;
    }

    private void checkValidation(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers == null || lottoNumbers.size() != LottoStaticConstants.LOTTO_TICKET_NUMBER_SIZE) {
            throw new IllegalArgumentException(LottoStaticConstants.LOTTO_TICKET_NUMBER_SIZE_ERROR_MESSAGE);
        }

        Set<LottoNumber> lottoNumbersWithoutDuplicates = new HashSet<>(lottoNumbers);
        if (lottoNumbersWithoutDuplicates.size() != LottoStaticConstants.LOTTO_TICKET_NUMBER_SIZE) {
            throw new IllegalArgumentException(LottoStaticConstants.LOTTO_TICKET_NUMBER_SIZE_ERROR_MESSAGE);
        }
    }

    public int countMatchingNumbers(WinningLottoNumber winningLottoNumber) {
        return winningLottoNumber.countMatchingNumbers(this.lottoTicket);
    }

    public boolean doesContainBonusNumber(WinningLottoNumber winningLottoNumber) {
        return winningLottoNumber.doesContainBonusNumber(this.lottoTicket);
    }

    @Override
    public String toString() {
        return lottoTicket.toString();
    }
}
