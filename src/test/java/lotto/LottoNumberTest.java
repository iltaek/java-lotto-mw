package lotto;

import com.sun.org.glassfish.gmbal.Description;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {
    @Test
    @Description("�ζ� ���ڸ� �����ϴ� ���� ��Ұ� ��Ȯ�ϰ� 45���� �´��� �׽�Ʈ.")
    void numberOfElementsOfLottoNumbersTest() {
        assertEquals(45, LottoNumber.values().length);
    }
}