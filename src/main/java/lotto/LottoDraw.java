package lotto;

import java.util.Map;

public class LottoDraw {
    private static LottoPapers userLottoPapers = new LottoPapers();
    private static WinningNumbers winningLottoNumbers;

    public static void inputWinningLottoPaper(String input4WinningNumbers) {
        winningLottoNumbers = WinningLottoNumberSelector.getWinningNumbers(input4WinningNumbers);
    }

    public static void submitMyLottoPapers(LottoPapers lottoPapers){
        userLottoPapers = lottoPapers;
    }

    public static void getLottoResult(){
        Map<Prize, Integer> resultMap = userLottoPapers.matchLottoPaper(winningLottoNumbers);

    }
}
