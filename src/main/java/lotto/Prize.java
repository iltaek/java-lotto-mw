package lotto;

public enum Prize {
    FIRST_PRIZE( 2000000000),
    SECOND_PRIZE( 30000000),
    THIRD_PRIZE( 1500000),
    FOURTH_PRIZE(50000),
    FIFTH_PRIZE(5000),
    LOSE_PRIZE(0);

    int prizeAmount;

    Prize(int prizeAmount) {
        this.prizeAmount = prizeAmount;
    }

    public static Prize of(int matchCounts) {
        switch (matchCounts) {
            case 3:
                return FIFTH_PRIZE;
            case 4:
                return FOURTH_PRIZE;
            case 5:
                return THIRD_PRIZE;
            case 15:
                return SECOND_PRIZE;
            case 6:
                return FIRST_PRIZE;
            default:
                return LOSE_PRIZE;
        }
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }
}
