package lotto;

import java.util.Map;

public class LottoDraw {

    final static int LOTTO_PRICE = 1000;
    private static LottoPapers userLottoPapers = new LottoPapers();
    private static WinningNumbers winningLottoNumbers;
    private static Map<Prize, Integer> resultMap;

    public static void inputWinningLottoPaper(String input4WinningNumbers) {
        winningLottoNumbers = WinningLottoNumberSelector.getWinningNumbers(input4WinningNumbers);
    }

    public static void submitMyLottoPapers(LottoPapers lottoPapers) {
        userLottoPapers = lottoPapers;
    }

    public static void printLottoResult() {
        resultMap = userLottoPapers.matchLottoPaper(winningLottoNumbers);
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(
            "3개 일치 (" + Prize.FIFTH_PRIZE.is() + "원)- " + resultMap.get(Prize.FIFTH_PRIZE) + "개");
        System.out.println(
            "4개 일치 (" + Prize.FOURTH_PRIZE.is() + "원)- " + resultMap.get(Prize.FOURTH_PRIZE) + "개");
        System.out.println(
            "5개 일치 (" + Prize.THIRD_PRIZE.is() + "원)- " + resultMap.get(Prize.THIRD_PRIZE) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (" + Prize.SECOND_PRIZE.is() + "원)- " + resultMap
            .get(Prize.SECOND_PRIZE) + "개");
        System.out.println(
            "6개 일치 (" + Prize.FIRST_PRIZE.is() + "원)- " + resultMap.get(Prize.FIRST_PRIZE) + "개");

        System.out.println("총 수익률은 " + getProfitRate() + "입니다.");
    }

    private static float getProfitRate() {
        int purchaseAmount = userLottoPapers.getLottoPapers().size() * LOTTO_PRICE;
        int resultAmount = Prize.FIFTH_PRIZE.is() * resultMap.get(Prize.FIFTH_PRIZE) +
            Prize.FOURTH_PRIZE.is() * resultMap.get(Prize.FOURTH_PRIZE) +
            Prize.THIRD_PRIZE.is() * resultMap.get(Prize.THIRD_PRIZE) +
            Prize.SECOND_PRIZE.is() * resultMap.get(Prize.SECOND_PRIZE) +
            Prize.FIRST_PRIZE.is() * resultMap.get(Prize.FIRST_PRIZE);

        return resultAmount / (float) purchaseAmount;
    }
}
