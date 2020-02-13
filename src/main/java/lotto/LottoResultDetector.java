package lotto;

import java.util.Arrays;

public class LottoResultDetector {
    public LottoResult getLottoResult(LottoTicket candidateLottoTicket, LottoWinningNumber lottoWinningNumber) {
        int matchingNumberCount = candidateLottoTicket.countMatchingNumbers(lottoWinningNumber);

        if (matchingNumberCount == 5) {
            boolean doesContainBonusNumber = candidateLottoTicket.doesContainBonusNumber(lottoWinningNumber);
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
