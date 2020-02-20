package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.sun.org.glassfish.gmbal.Description;
import org.junit.jupiter.api.Test;

class LottoNumberAutoSelectorTest {

    @Test
    @Description("로또 자동으로 숫자가 6개 선택되어 생성되는지 테스트")
    public void isSixRandomNumberGenerated() {
        assertThat(LottoNumberAutoSelector.autoMarking().getMarkedLottoNumbers()).hasSize(6);
    }

    @Test
    @Description("자동으로 생성된 로또 숫자들이 중복되지 않는지 테스트")
    public void isNotDuplicatedNumbers() {
        assertThat(LottoNumberAutoSelector.autoMarking().getMarkedLottoNumbers())
            .doesNotHaveDuplicates();
    }
}