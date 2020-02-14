package lotto;

import java.util.Scanner;

public class LottoUserInputReceiver {
    private final LottoUserInput lottoUserInput = new LottoUserInput();
    private final Scanner scanner = new Scanner(System.in);

    public LottoUserInput receiveLottoPurchaseInformation() {
        boolean result = getNumberOfPurchasedLottoTicket();
        while (!result) {
            result = getNumberOfPurchasedLottoTicket();
        }

        result = getNumberOfManuallyPurchasedLottoTicket();
        while (!result) {
            result = getNumberOfManuallyPurchasedLottoTicket();
        }

        if (lottoUserInput.getNumberOfManuallyPurchasedLottoTicket() > 0) {
            manuallyPurchaseLottoTicket();
        }

        return lottoUserInput;
    }

    public LottoUserInput receiveLottoWinningNumberInformation() {
        boolean result = getLottoWinningTicket();
        while (!result) {
            result = getLottoWinningTicket();
        }

        result = getBonusNumber();
        while (!result) {
            result = getBonusNumber();
        }

        return lottoUserInput;
    }

    private boolean getNumberOfPurchasedLottoTicket() {
        try {
            System.out.println("로또 구입 금액을 입력해 주세요 (로또 한 장 가격인 1000의 배수 입력).");
            lottoUserInput.setNumberOfPurchasedLottoTicket(scanner.nextLine());
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private boolean getNumberOfManuallyPurchasedLottoTicket() {
        try {
            System.out.println("수동으로 구매 할 로또 수를 입력해 주세요.");
            lottoUserInput.setNumberOfManuallyPurchasedLottoTicket(scanner.nextLine());
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private void manuallyPurchaseLottoTicket() {
        System.out.println("수동으로 구매 할 로또 번호를 입력해주세요 (쉼표로 숫자 구분).");
        for (int i = 0; i < lottoUserInput.getNumberOfManuallyPurchasedLottoTicket(); i++) {
            manuallyPurchaseLottoTicket(i);
        }
    }

    private void manuallyPurchaseLottoTicket(int order) {
        boolean result = getManuallyPurchasedLottoTicket(order);
        while (!result) {
            result = getManuallyPurchasedLottoTicket(order);
        }
    }

    private boolean getManuallyPurchasedLottoTicket(int order) {
        try {
            System.out.println(order + 1 + "번째 로또 번호 : ");
            lottoUserInput.addManuallyPurchasedLottoTicket(scanner.nextLine());
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private boolean getLottoWinningTicket() {
        try {
            System.out.println("지난 주 당첨 번호를 입력해 주세요.");
            lottoUserInput.setLottoWinningTicket(scanner.nextLine());
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private boolean getBonusNumber() {
        try {
            System.out.println("지난 주 보너스 번호를 입력해 주세요.");
            lottoUserInput.setBonusNumber(scanner.nextLine());
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
