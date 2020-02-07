package lotto;

public class UserInputValidator {

    final static int LOTTO_PRICE = 1000;

    public static void validatePurchaseInput(int purchaseInput) {
        if (purchaseInput < LOTTO_PRICE) {
            throw new IllegalArgumentException("1000원 이상 구매하셔야 합니다.");
        }
    }

    public static void validateManualSelectingCounts(int purchase, int mnualSelectingCounts) {
        if (mnualSelectingCounts < 0) {
            throw new IllegalArgumentException("수동 입력 개수는 자연수만 입력 가능합니다.");
        }

        if (mnualSelectingCounts > purchase / LOTTO_PRICE) {
            throw new IllegalArgumentException("로또 구매 금액을 초과하였습니다.");
        }
    }

    public static void validateSelectedSixNumbers(String[] manualSelectInts) {
        if (manualSelectInts.length != 6) {
            throw new IllegalArgumentException("6개의 로또 번호를 선택하셔야 합니다.");
        }
    }

    public static void validateDuplicationNumbers(LottoNumber[] lottoNumbers) {
        for (LottoNumber lottoNumber : lottoNumbers){

        }
    }
}
