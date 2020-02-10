import com.sun.org.glassfish.gmbal.Description;
import lotto.LottoNumberAutoSelector;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberGenTest {

    @Test
    @Description("로또 숫자가 자동으로 6개 선택되어 생성되는지 테스트")
    public void isSixRandomNumberGenerated() {
        int autoSelectedCount = 100;
        for (int i =0 ;i <autoSelectedCount; i++) {
            assertThat(LottoNumberAutoSelector.autoMarking().getMarkedLottoNumbers()).hasSize(6);
        }
    }

    @Test
    @Description("자동으로 생성된 로또 숫자들이 중복되지 않는지 테스트")
    public void isNotDuplicatedNumbers() {
        int autoSelectedCount = 10;
        for (int i =0 ;i <autoSelectedCount; i++) {
            assertThat(LottoNumberAutoSelector.autoMarking().getMarkedLottoNumbers()).doesNotHaveDuplicates();
        }
    }
}
