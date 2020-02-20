package lotto;

import com.sun.org.glassfish.gmbal.Description;
import lotto.LottoNumberManuallySelector;
import lotto.UserInputValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class UserInputValidatorTest {

    @Test
    @Description("로또 구입 금액에 대한 유저 입력 값이 1000 미만이면 IllegalArgumentException 이 발생하는지 테스트")
    public void invalidInputForPurchaseTest() {
        int purchaseInput = -1000;

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            UserInputValidator.validatePurchaseInput(purchaseInput);
        });
    }

    @Test
    @Description("로또 수동 구매에 대한 유저 입력 값이 0 미만이면 IllegalArgumentException 이 발생하는지 테스트")
    public void invalidInputForManualCountTest() {
        int purchaseInput = 5000;
        int manualCountInput = -1;
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            UserInputValidator.validateManualSelectingCounts(purchaseInput, manualCountInput);
        }).withMessage("수동 입력 개수는 자연수만 입력 가능합니다.");
    }

    @Test
    @Description("로또 수동 구매에 대한 유저 입력 값이 구매 가능한 개수(로또 구입 금액 / 1000)보다 IllegalArgumentException 이 발생하는지 테스트")
    public void invalidInputForManualCountTest2() {
        int purchaseInput = 5000;
        int manualCountInput = 6;

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            UserInputValidator.validateManualSelectingCounts(purchaseInput, manualCountInput);
        }).withMessage("로또 구매 금액을 초과하였습니다.");
    }
}
