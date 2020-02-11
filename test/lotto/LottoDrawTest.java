package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import com.sun.org.glassfish.gmbal.Description;
import org.junit.jupiter.api.Test;

class LottoDrawTest {

    @Test
    @Description("구매한 로또의 결과가 모두 나오는지 테스트")
    public void printAllResultTest(){
        LottoPapers lottoPapers = new LottoPapers();
        lottoPapers.addLottoPaper(LottoNumberAutoSelector.autoMarking());
//        assertThat();
    }
}