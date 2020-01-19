package lotto;

public class UserInputValidator {
    public static void validatePurchaseInput(int purchaseInput) {
        if ( purchaseInput < 1000) {
            throw new IllegalArgumentException("1000원 이상 구매하셔야 합니다.");
        }
    }

    public static void validateManualCount(int manualCount) {
        if ( manualCount < 0 ) {
            throw new IllegalArgumentException("자연수만 입력 가능합니다.");
        }
    }

    public static void validateManualPick(int[] manualPick) {
        for ( int pickNumber : manualPick) {
            if( pickNumber < 0 || pickNumber > 45) {
                throw new IllegalArgumentException("로또 번호는 1~45 사이의 수만 입력 가능합니다.");
            }
        }
    }
}
