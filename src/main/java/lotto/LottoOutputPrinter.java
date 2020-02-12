package lotto;

public class LottoOutputPrinter {
    public String printResultOfPurchase(LottoTickets lottoTickets, int numberOfLottoTicketPurchasedManually) {
        return "수동으로 " +
                numberOfLottoTicketPurchasedManually +
                "장, 자동으로 " +
                (lottoTickets.numberOfLottoTicketPurchased() - numberOfLottoTicketPurchasedManually) +
                "장을 구매했습니다." +
                "\n" +
                lottoTickets.printAllLottoNumbers();
    }

    public String printResultOfStatistics(LottoResults lottoResults) {
        return "당첨 통계" +
                "\n" +
                "----------------------------------------" +
                "\n" +
                "3개 일치 (5000원) - " +
                lottoResults.getAmountOfFifthPrize() +
                "개" +
                "\n" +
                "4개 일치 (50000원) - " +
                lottoResults.getAmountOfFourthPrize() +
                "개" +
                "\n" +
                "5개 일치 (1500000원) - " +
                lottoResults.getAmountOfThirdPrize() +
                "개" +
                "\n" +
                "5개 일치, 보너스 볼 일치 (30000000원) - " +
                lottoResults.getAmountOfSecondPrize() +
                "개" +
                "\n" +
                "6개 일치 (2000000000원) - " +
                lottoResults.getAmountOfFirstPrize() +
                "개" +
                "\n" +
                "총 수익률은 " +
                lottoResults.getRateOfReturn() +
                "입니다.";
    }
}
