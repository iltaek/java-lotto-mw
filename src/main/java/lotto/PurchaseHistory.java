package lotto;

import java.util.List;

public class PurchaseHistory {

    private static String purchasedNumbers = "";

    public static void print(LottoPapers lottoPapers, int manuallySelectedPapers) {
        List<LottoPaper> lottoPaperList = lottoPapers.getLottoPapers();

        System.out.println(
            "수동으로 " + manuallySelectedPapers + "장, 자동으로 "
                + (lottoPaperList.size() - manuallySelectedPapers)
                + "개를 구매했습니다.");

        for (LottoPaper lottoPaper : lottoPaperList) {
            purchasedNumbers += "[" + lottoPaper.toString() + "]\n";
        }

        System.out.println(purchasedNumbers);
    }
}
