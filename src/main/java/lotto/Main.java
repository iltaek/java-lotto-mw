package lotto;

import java.util.Scanner;

public class Main {

    final static int LOTTO_PRICE = 1000;
    static LottoPapers lottoPapers;

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

        String userInput4ManualSelect;
        for (int i = 0; i < userInput4ManualSelectingCounts; i++) {
            System.out.println("수동으로 구매할 번호를 입력해 주세요.");
            userInput4ManualSelect = userInput.next();
            LottoPaper lottoPaper = LottoNumberManuallySelector.marking(userInput4ManualSelect);
            lottoPapers.addLottoPaper(lottoPaper);
        }

        for (int i = 0; i < availableAmount; i++) {
            LottoPaper lottoPaper = LottoNumberAutoSelector.autoMarking();
            lottoPapers.addLottoPaper(lottoPaper);

//        PurchaseHistory.print(intArray4ManualSelect, intArray4AutoSelect);
        }

    }
}
