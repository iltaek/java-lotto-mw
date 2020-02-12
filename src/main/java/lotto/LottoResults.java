package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoResults {
    private List<LottoResult> lottoResults = new ArrayList<>();

    public void addLottoResult(LottoResult lottoResult) {
        this.lottoResults.add(lottoResult);
    }

    public int getAmountOfFifthPrize() {
        return getAmountOfGivenPrize(LottoResult.FIFTH_PRIZE);
    }

    public int getAmountOfFourthPrize() {
        return getAmountOfGivenPrize(LottoResult.FOURTH_PRIZE);
    }

    public int getAmountOfThirdPrize() {
        return getAmountOfGivenPrize(LottoResult.THIRD_PRIZE);
    }

    public int getAmountOfSecondPrize() {
        return getAmountOfGivenPrize(LottoResult.SECOND_PRIZE);
    }

    public int getAmountOfFirstPrize() {
        return getAmountOfGivenPrize(LottoResult.FIRST_PRIZE);
    }

    private int getAmountOfGivenPrize(LottoResult givenLottoResult) {
        return (int) this.lottoResults.stream()
                .filter(lottoResult -> lottoResult.equals(givenLottoResult))
                .count();
    }

    public float getRateOfReturn() {
        float sumOfTotalMoneyPrize = new LottoResult.MoneyPrizeDistributor()
                .getSumOfTotalMoneyPrizes(this.lottoResults);
        float priceOfLottoTicketPurchased = this.lottoResults.size() * LottoStaticConstants.LOTTO_TICKET_PRICE;

        return sumOfTotalMoneyPrize / priceOfLottoTicketPurchased;
    }
}
