package lotto;

import java.util.Scanner;

public class Main {
    static final String DELIMITER = ",";
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.println("구입금액을 입력해 주세요.");
        int userInput4Purchase = userInput.nextInt();
        UserInputValidator.validatePurchaseInput(userInput4Purchase);

        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int userInput4ManualCount = userInput.nextInt();
        UserInputValidator.validateManualCount(userInput4Purchase, userInput4ManualCount);

        String userInput4ManualPick;
        int[][] intArray4ManualPick = new int[userInput4ManualCount][];
        for ( int i = 0 ; i < userInput4ManualCount; i++) {
            System.out.println("수동으로 구매할 번호를 입력해 주세요.");
            userInput4ManualPick = userInput.next();
            intArray4ManualPick[i] = covertStringArrayToIntArray(userInput4ManualPick.split(DELIMITER));
            UserInputValidator.validateManualPick(intArray4ManualPick[i]);
        }
    }

    private static int[] covertStringArrayToIntArray(String[] strArray){
        int[] intArray = new int[strArray.length];
        for( int i =0 ; i < strArray.length; i++) {
            intArray[i] = Integer.parseInt(strArray[i]);
        }

        return intArray;
    }
}
