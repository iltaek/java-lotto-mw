import com.sun.org.glassfish.gmbal.Description;
import lotto.UserInputValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class UserInputTest {

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
            UserInputValidator.validateManualCount(purchaseInput, manualCountInput);
        }).withMessage("수동 입력 개수는 자연수만 입력 가능합니다.");
    }

    @Test
    @Description("로또 수동 구매에 대한 유저 입력 값이 구매 가능한 개수(로또 구입 금액 / 1000)보다 IllegalArgumentException 이 발생하는지 테스트")
    public void invalidInputForManualCountTest2() {
        int purchaseInput = 5000;
        int manualCountInput = 6;

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            UserInputValidator.validateManualCount(purchaseInput, manualCountInput);
        }).withMessage("로또 구매 금액을 초과하였습니다.");
    }

    @Test
    @Description("로또 번호 수동 입력에 대한 유저 입력 값이 1~45 사이의 수가 아니면 IllegalArgumentException 이 발생하는지 테스트")
    public void invalidInputForManualPickTest() {
        int[] testInput = {1, 2, 3, 4, 5, 48};

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            UserInputValidator.validateManualPick(testInput);
        }).withMessage("로또 번호는 1~45 사이의 수만 입력 가능합니다.");
    }

    @Test
    @Description("로또 번호 수동 입력에 대한 유저 입력 값이 6개가 아니면 아니면 IllegalArgumentException 이 발생하는지 테스트")
    public void invalidInputForManualPickCountsTest() {
        int[] testInput = {1, 2, 3, 4, 5, 6, 7, 8};

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            UserInputValidator.validateManualPick(testInput);
        }).withMessage("6개의 로또 번호를 선택하셔야 합니다.");
    }
}
