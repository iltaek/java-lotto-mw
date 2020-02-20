package lotto;

public enum Prize {
    FIRST_PRIZE( 6,2000000000),
    SECOND_PRIZE( 5,30000000),
    THIRD_PRIZE( 5,1500000),
    FOURTH_PRIZE(4,50000),
    FIFTH_PRIZE(3,5000),
    LOSE_PRIZE(0,0);

    private int prizeAmount;
    private int matchCount;
    Prize(int matchCount, int prizeAmount) {
        this.matchCount = matchCount;
        this.prizeAmount = prizeAmount;
    }

    public int required() { return matchCount; }

    public int is() {
        return prizeAmount;
    }
}
