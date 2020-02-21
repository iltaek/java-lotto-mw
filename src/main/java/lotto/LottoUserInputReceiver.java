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
            System.out.println("�ζ� ���� �ݾ��� �Է��� �ּ��� (�ζ� �� �� ������ 1000�� ��� �Է�).");
            lottoUserInput.setNumberOfPurchasedLottoTicket(scanner.nextLine());
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private boolean getNumberOfManuallyPurchasedLottoTicket() {
        try {
            System.out.println("�������� ���� �� �ζ� ���� �Է��� �ּ���.");
            lottoUserInput.setNumberOfManuallyPurchasedLottoTicket(scanner.nextLine());
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private void manuallyPurchaseLottoTicket() {
        System.out.println("�������� ���� �� �ζ� ��ȣ�� �Է����ּ��� (��ǥ�� ���� ����).");
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
            System.out.println(order + 1 + "��° �ζ� ��ȣ : ");
            lottoUserInput.addManuallyPurchasedLottoTicket(scanner.nextLine());
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private boolean getLottoWinningTicket() {
        try {
            System.out.println("���� �� ��÷ ��ȣ�� �Է��� �ּ���.");
            lottoUserInput.setLottoWinningTicket(scanner.nextLine());
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private boolean getBonusNumber() {
        try {
            System.out.println("���� �� ���ʽ� ��ȣ�� �Է��� �ּ���.");
            lottoUserInput.setBonusNumber(scanner.nextLine());
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
