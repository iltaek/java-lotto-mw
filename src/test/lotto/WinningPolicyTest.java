package lotto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WinningPolicyTest {
    @Test
    public void getPolicyTest() {
        SelectedNumbers a = new SelectedNumbers(new int[]{1,2,3,4,5,6});
        SelectedNumbers winningNumbers = new SelectedNumbers(new int[]{1,2,3,4,5,45});
        LottoNumber bonusNumber = new LottoNumber(6);
        assertEquals(WinningPolicy.FIVE_BONUS, WinningPolicy.getWinningPolicy(a, winningNumbers, bonusNumber));
    }
}