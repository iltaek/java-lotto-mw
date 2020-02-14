package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

import com.sun.org.glassfish.gmbal.Description;
import org.junit.jupiter.api.Test;

class LottoPaperTest {

    @Test
    @Description("숫자들이 중복되지 않는지 테스트")
    public void isNotDuplicatedNumbers() {
        String testInput = "1,2,3,4,5,5";
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            LottoNumberManuallySelector.marking(testInput).getMarkedLottoNumbers();
        }).withMessage("로또 번호는 중복될 수 없습니다.");
    }
}