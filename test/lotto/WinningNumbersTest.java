package lotto;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

import com.sun.org.glassfish.gmbal.Description;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    @Test
    @Description("당첨 번호들이 중복되지 않는지 테스트")
    public void isNotDuplicatedNumbers() {
        String testInput = "1,2,3,4,5,6,6";
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new WinningNumbers(
                WinningLottoNumberSelector.getWinningNumbers(testInput).getWinningNumbers());
        }).withMessage("당첨 번호는 중복될 수 없습니다.");
    }
}