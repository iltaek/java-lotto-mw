package lotto;

import java.util.Arrays;

public enum WinningPolicy {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE_DEFAULT(5, false, 1500000),
    FIVE_BONUS(5, true, 30000000),
    SIX(6, 2000000000);

    private int matchNumber;
    private int award;
    private boolean bonus;

    WinningPolicy(int number, int award) {
        this.matchNumber = number;
        this.award = award;
    }

    WinningPolicy(int number, boolean bonus, int award) {
        this.matchNumber = number;
        this.bonus = bonus;
        this.award = award;
    }

    int getMatchNumber() {
       return matchNumber;
    }

    int getAward() {
        return award;
    }

    static WinningPolicy getWinningPolicy(SelectedNumbers selectedNumbers, SelectedNumbers winningNumbers, LottoNumber bonus) {
        int matchedNumberCount = selectedNumbers.countDuplicateNumbers(winningNumbers);
        if (matchedNumberCount < 3) {
            return null;
        }

        if (matchedNumberCount == 5) {
            if (selectedNumbers.contains(bonus)) {
                return FIVE_BONUS;
            }
            return FIVE_DEFAULT;
        }

        return getWinningPolicyOfMatchedNumber(matchedNumberCount);
    }

    //for 3,4,6
    private static WinningPolicy getWinningPolicyOfMatchedNumber(int matchingNumberCount) {
        return Arrays.stream(WinningPolicy.values())
                .filter(p -> p.getMatchNumber() == matchingNumberCount)
                .findFirst()
                .orElse(null);
    }
}
