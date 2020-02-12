package lotto;

public class LottoOutputPrinter {
    public String printResultOfPurchase(LottoTickets lottoTickets, int numberOfLottoTicketPurchasedManually) {
        return "�������� " +
                numberOfLottoTicketPurchasedManually +
                "��, �ڵ����� " +
                (lottoTickets.numberOfLottoTicketPurchased() - numberOfLottoTicketPurchasedManually) +
                "���� �����߽��ϴ�." +
                "\n" +
                lottoTickets.printAllLottoNumbers();
    }

    public String printResultOfStatistics(LottoResults lottoResults) {
        return "��÷ ���" +
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
    }
}
