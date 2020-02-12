package lotto;

public enum  LottoResult {
    /*
        형식 : 상_이름(일치하는 숫자 갯수, 상금)
     */
    FIRST_PRIZE(6, 2000000000),
    SECOND_PRIZE(5, 30000000),
    THIRD_PRIZE(5, 1500000),
    FOURTH_PRIZE(4, 50000),
    FIFTH_PRIZE(3, 5000),
    NO_PRIZE(0, 0);

    private final int matchingNumberCount;
    private final int prizeMoney;

    LottoResult(int matchingNumberCount, int prizeMoney) {
        this.matchingNumberCount = matchingNumberCount;
        this.prizeMoney = prizeMoney;
    }

    public boolean isCorrespondingMatchingNumberCount(int count) {
        return this.matchingNumberCount == count;
    }
}
