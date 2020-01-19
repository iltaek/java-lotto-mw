package lotto;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.println("구입금액을 입력해 주세요.");
        int userInput4Purchase = userInput.nextInt();
        UserInputValidator.validatePurchaseInput(userInput4Purchase);

        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int userInput4ManualCount = userInput.nextInt();
        UserInputValidator.validateManualCount(userInput4ManualCount);

        String userInput4ManualPick;
        for ( int i = 0 ; i < userInput4ManualCount; i++) {
            userInput4ManualPick = userInput.next();

        }
    }
}
