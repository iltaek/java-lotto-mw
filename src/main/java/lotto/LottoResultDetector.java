package lotto;

import java.util.Arrays;

public class LottoResultDetector {
    public LottoResult getLottoResult(LottoTicket candidateLottoTicket, WinningLottoNumber winningLottoNumber) {
        int matchingNumberCount = candidateLottoTicket.countMatchingNumbers(winningLottoNumber);

        if (matchingNumberCount == 5) {
            boolean doesContainBonusNumber = candidateLottoTicket.doesContainBonusNumber(winningLottoNumber);
            return getLottoResultWithRespectToBonusNumber(doesContainBonusNumber);
        }

        return getLottoResultWithRespectToMatchingNumberCount(matchingNumberCount);
    }

    private LottoResult getLottoResultWithRespectToBonusNumber(boolean doesContainBonusNumber) {
        if(doesContainBonusNumber) {
            return LottoResult.SECOND_PRIZE;
        }

        return LottoResult.THIRD_PRIZE;
    }

    private LottoResult getLottoResultWithRespectToMatchingNumberCount(int matchingNumberCount) {
        return Arrays.stream(LottoResult.values())
                .filter(lottoResult -> lottoResult.isCorrespondingMatchingNumberCount(matchingNumberCount))
                .findFirst()
                .orElse(LottoResult.NO_PRIZE);
    }
}
