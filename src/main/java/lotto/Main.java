package lotto;

import java.util.Scanner;

public class Main {

    final static int LOTTO_PRICE = 1000;
    static LottoPapers lottoPapers = new LottoPapers();

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.println("구입금액을 입력해 주세요.");
        int userInput4Purchase = userInput.nextInt();
        UserInputValidator.validatePurchaseInput(userInput4Purchase);

        int availableAmount = userInput4Purchase / LOTTO_PRICE;

        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int userInput4ManualSelectingCounts = userInput.nextInt();
        UserInputValidator
            .validateManualSelectingCounts(userInput4Purchase, userInput4ManualSelectingCounts);

        availableAmount -= userInput4ManualSelectingCounts;

        // 수동 구입
        String userInput4ManualSelect;
        for (int i = 0; i < userInput4ManualSelectingCounts; i++) {
            System.out.println("수동으로 구매할 번호를 입력해 주세요.");
            userInput4ManualSelect = userInput.next();
            LottoPaper lottoPaper = LottoNumberManuallySelector.marking(userInput4ManualSelect);
            lottoPapers.addLottoPaper(lottoPaper);
        }

        // 자동 구입
        for (int i = 0; i < availableAmount; i++) {
            LottoPaper lottoPaper = LottoNumberAutoSelector.autoMarking();
            lottoPapers.addLottoPaper(lottoPaper);
        }

        // 구매 내역
        PurchaseHistory.print(lottoPapers, userInput4ManualSelectingCounts);

        // 지난 주 당첨 번호 입력
        String userInput4winningNumbers;
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        userInput4winningNumbers = userInput.next();
        System.out.println("보너스 볼을 입력해 주세요.");
        userInput4winningNumbers += "," + userInput.next();

        LottoDraw.inputWinningLottoPaper(userInput4winningNumbers);
        LottoDraw.submitMyLottoPapers(lottoPapers);
        LottoDraw.getLottoResult();
    }
}
