package lotto;

import java.util.Scanner;

public class LottoUserInputReceiver {
    private final LottoUserInput lottoUserInput = new LottoUserInput();
    private final Scanner scanner = new Scanner(System.in);

    public LottoUserInput receiveLottoPurchaseInformation() {
        System.out.println("�ζ� ���� �ݾ��� �Է��� �ּ��� (�ζ� �� �� ������ 1000�� ��� �Է�).");
        lottoUserInput.setNumberOfPurchasedLottoTicket(scanner.nextLine());

        System.out.println("�������� ���� �� �ζ� ���� �Է��� �ּ���.");
        lottoUserInput.setNumberOfManuallyPurchasedLottoTicket(scanner.nextLine());

        System.out.println("�������� ���� �� �ζ� ��ȣ�� �Է����ּ��� (��ǥ�� ���� ����).");
        for (int i = 0; i < lottoUserInput.getNumberOfManuallyPurchasedLottoTicket(); i++) {
            System.out.println(i + 1 + "��° �ζ� ��ȣ : ");
            lottoUserInput.addManuallyPurchasedLottoTicket(scanner.nextLine());
        }

        return lottoUserInput;
    }

    public LottoUserInput receiveLottoWinningNumberInformation() {
        System.out.println("���� �� ��÷ ��ȣ�� �Է��� �ּ���.");
        lottoUserInput.setLottoWinningNumbers(scanner.nextLine());

        System.out.println("���� �� ���ʽ� ��ȣ�� �Է��� �ּ���.");
        lottoUserInput.setBonusNumber(scanner.nextLine());

        return lottoUserInput;
    }
}
