package lotto;

import com.sun.org.glassfish.gmbal.Description;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {
    @Test
    @Description("로또 숫자를 구성하는 숫자 요소가 정확하게 45개가 맞는지 테스트.")
    void numberOfElementsOfLottoNumbersTest() {
        assertEquals(45, LottoNumber.values().length);
    }
}