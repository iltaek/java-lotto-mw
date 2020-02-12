package lotto;

public enum  LottoResult {
    /*
        ���� : ��_�̸�(��ġ�ϴ� ���� ����, ���)
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
