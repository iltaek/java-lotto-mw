package lotto;

import java.util.Scanner;

public class LottoUserInputReceiver {
    private final LottoUserInput lottoUserInput = new LottoUserInput();
    private final Scanner scanner = new Scanner(System.in);

    public LottoUserInput receiveLottoPurchaseInformation() {
        System.out.println("로또 구입 금액을 입력해 주세요 (로또 한 장 가격인 1000의 배수 입력).");
        lottoUserInput.setNumberOfPurchasedLottoTicket(scanner.nextLine());

        System.out.println("수동으로 구매 할 로또 수를 입력해 주세요.");
        lottoUserInput.setNumberOfManuallyPurchasedLottoTicket(scanner.nextLine());

        System.out.println("수동으로 구매 할 로또 번호를 입력해주세요 (쉼표로 숫자 구분).");
        for (int i = 0; i < lottoUserInput.getNumberOfManuallyPurchasedLottoTicket(); i++) {
            System.out.println(i + 1 + "번째 로또 번호 : ");
            lottoUserInput.addManuallyPurchasedLottoTicket(scanner.nextLine());
        }

        return lottoUserInput;
    }

    public LottoUserInput receiveLottoWinningNumberInformation() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        lottoUserInput.setLottoWinningNumbers(scanner.nextLine());

        System.out.println("지난 주 보너스 번호를 입력해 주세요.");
        lottoUserInput.setBonusNumber(scanner.nextLine());

        return lottoUserInput;
    }
}
