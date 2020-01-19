import com.sun.org.glassfish.gmbal.Description;
import lotto.UserInputValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserInputTest {
    @Test
    @Description("로또 구입 금액에 대한 유저 입력 값이 1000 미만이면 IllegalArgumentException 이 발생하는지 테스트")
    public void invalidInputForPurchaseTest(){
        int testInput = -1000;

        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            UserInputValidator.validatePurchaseInput(testInput);
        });
    }

    @Test
    @Description("로또 수동 구매에 대한 유저 입력 값이 0 미만이면 IllegalArgumentException 이 발생하는지 테스트")
    public void invalidInputForManualCountTest(){
        int testInput = -1000;

        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            UserInputValidator.validateManualCount(testInput);
        });
    }

    @Test
    @Description("로또 번호 수동 입력에 대한 유저 입력 값이 1~45 사이의 수가 아니면 IllegalArgumentException 이 발생하는지 테스트")
    public void invalidInputForManualPickTest(){
        int[] testInput = {1,2,3,4,5,48};

        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            UserInputValidator.validateManualPick(testInput);
        });
    }

    @Test
    @Description("로또 번호 수동 입력에 대한 유저 입력 값이 6개가 아니면 아니면 IllegalArgumentException 이 발생하는지 테스트")
    public void invalidInputForManualPickCountsTest(){
        int[] testInput = {1,2,3,4,5,6,7,8};

        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            UserInputValidator.validateManualPick(testInput);
        });
    }

}
