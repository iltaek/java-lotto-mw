package lotto;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import com.sun.org.glassfish.gmbal.Description;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

    @Test
    @Description("로또 번호 값이 1~45 사이의 수가 아니면 IllegalArgumentException 이 발생하는지 테스트")
    public void invalidInputForManualPickTest() {
        int testInput = 46;

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            LottoNumber.of(testInput);
        }).withMessage("로또 번호는 1~45 사이의 수만 입력 가능합니다.");
    }

    @Test
    @Description("로또 번호의 내용이 같으면 LottoNumber 는 같은 것이어야 한다.")
    public void lottoNumberTest1() {
        LottoNumber num1 = LottoNumber.of(1);
        LottoNumber num2 = LottoNumber.of(1);

        assertThat(num1).isEqualTo(num2);
    }

}