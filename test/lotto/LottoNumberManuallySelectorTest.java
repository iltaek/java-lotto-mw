package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

import com.sun.org.glassfish.gmbal.Description;
import org.junit.jupiter.api.Test;

class LottoNumberManuallySelectorTest {
    @Test
    @Description("로또 번호 수동 입력에 대한 유저 입력 값이 6개가 아니면 IllegalArgumentException 이 발생하는지 테스트")
    public void invalidInputForManualSelectingCountsTest() {
        String testInput = "1,2,3,4,5,6,7";

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            LottoNumberManuallySelector.marking(testInput);
        }).withMessage("6개의 로또 번호를 선택하셔야 합니다.");
    }

    @Test
    @Description("로또 숫자들이 중복되면 IllegalArgumentException 발생하는지 테스트")
    public void isNotDuplicatedNumbers() {
        String manualInputTestValues = "1,2,3,4,5,5";
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            LottoNumberManuallySelector.marking(manualInputTestValues).getMarkedLottoNumbers();
        }).withMessage("로또 번호는 중복될 수 없습니다.");
    }
}