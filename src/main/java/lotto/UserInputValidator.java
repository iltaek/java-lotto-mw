package lotto;

public class UserInputValidator {
    final static int LOTTO_PRICE = 1000;
    public static void validatePurchaseInput(int purchaseInput) {
        if ( purchaseInput < LOTTO_PRICE) {
            throw new IllegalArgumentException("1000원 이상 구매하셔야 합니다.");
        }
    }

    public static void validateManualCount(int purchase, int manualCountInput) {
        if ( manualCountInput < 0 ) {
            throw new IllegalArgumentException("수동 입력 개수는 자연수만 입력 가능합니다.");
        }

        if ( manualCountInput >purchase / LOTTO_PRICE) {
            throw new IllegalArgumentException("로또 구매 금액을 초과하였습니다.");
        }
    }

    public static void validateManualPick(int[] manualPickInput) {
        if ( manualPickInput.length != 6) {
            throw new IllegalArgumentException("6개의 로또 번호를 선택하셔야 합니다.");
        }
        for ( int pickNumber : manualPickInput) {
            if( pickNumber < 0 || pickNumber > 45) {
                throw new IllegalArgumentException("로또 번호는 1~45 사이의 수만 입력 가능합니다.");
            }
        }
    }
}
