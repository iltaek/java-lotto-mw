package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.sun.org.glassfish.gmbal.Description;
import org.junit.jupiter.api.Test;

class PrizeTest {
    @Test
    @Description("상품의 개수가 6개인지 테스트")
    public void printAllResultTest(){
        assertThat(Prize.values().length).isEqualTo(6);
    }
}