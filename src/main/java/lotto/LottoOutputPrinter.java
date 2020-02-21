package lotto;

public class LottoOutputPrinter {
    public void printResultOfPurchase(LottoTickets lottoTickets) {
        String result =  "�������� " +
                lottoTickets.getNumberOfManuallyPurchasedLottoTicket() +
                "��, �ڵ����� " +
                lottoTickets.getNumberOfAutomaticallyPurchasedLottoTicket() +
                "���� �����߽��ϴ�." +
                "\n" +
                lottoTickets.printAllLottoNumbers();

        System.out.println(result);
    }

    public void printResultOfStatistics(LottoResults lottoResults) {
        String result =  "��÷ ���" +
                "\n" +
                "----------------------------------------" +
                "\n" +
                "3�� ��ġ (5000��) - " +
                lottoResults.getAmountOfFifthPrize() +
                "��" +
                "\n" +
                "4�� ��ġ (50000��) - " +
                lottoResults.getAmountOfFourthPrize() +
                "��" +
                "\n" +
                "5�� ��ġ (1500000��) - " +
                lottoResults.getAmountOfThirdPrize() +
                "��" +
                "\n" +
                "5�� ��ġ, ���ʽ� �� ��ġ (30000000��) - " +
                lottoResults.getAmountOfSecondPrize() +
                "��" +
                "\n" +
                "6�� ��ġ (2000000000��) - " +
                lottoResults.getAmountOfFirstPrize() +
                "��" +
                "\n" +
                "�� ���ͷ��� " +
                lottoResults.getRateOfReturn() +
                "�Դϴ�.";

        System.out.println(result);
    }
}
