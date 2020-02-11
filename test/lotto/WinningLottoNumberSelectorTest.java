package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import com.sun.org.glassfish.gmbal.Description;
import org.junit.jupiter.api.Test;

class WinningLottoNumberSelectorTest {

    @Test
    @Description("당첨 숫자가 보너스까지 포함되어 7개 선택되어 생성되는지 테스트")
    public void isSevenRandomNumberGenerated() {
        assertThat(LottoNumberAutoSelector.autoMarking().getMarkedLottoNumbers()).hasSize(7);
    }
}