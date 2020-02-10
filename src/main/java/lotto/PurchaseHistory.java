package lotto;

import java.util.List;

public class PurchaseHistory {

    private static String purchasedNumbers = "";
    private static int autoSelectedPapers = 0;

    public static void print(LottoPapers lottoPapers) {
        List<LottoPaper> lottoPaperList = lottoPapers.getLottoPapers();

        for (LottoPaper lottoPaper : lottoPaperList) {
            countAutoSelected(lottoPaper);
            purchasedNumbers += "[" + lottoPaper.toString() + "]\n";
        }

        System.out.println(
            "수동으로 " + (lottoPaperList.size() - autoSelectedPapers) + "장, 자동으로 "
                + autoSelectedPapers
                + "개를 구매했습니다.");

        System.out.println(purchasedNumbers);
    }

    private static void countAutoSelected(LottoPaper lottoPaper) {
        if (lottoPaper.isAutoSelected()) {
            autoSelectedPapers++;
        }
    }
}
