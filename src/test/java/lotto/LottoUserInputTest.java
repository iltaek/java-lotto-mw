package lotto;

import com.sun.org.glassfish.gmbal.Description;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoUserInputTest {

    @ParameterizedTest
    @Description("로또 구입 금액으로 소수나 음수가 입력되었을 경우 에러가 발생하는지 테스트.")
    @ValueSource(strings = {"0.1", "1000.5", "-1", "-1000"})
    void setNumberOfPurchasedLottoTicketTest_1(String priceOfPurchasedLottoTicketString) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoUserInput().setNumberOfPurchasedLottoTicket(priceOfPurchasedLottoTicketString))
                .withMessage(LottoStaticConstants.LOTTO_INPUT_NUMBER_INVALID_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @Description("로또 구입 금액으로 1000원의 배수가 아닌 수가 입력되었을 경우 에러가 발생하는지 테스트.")
    @ValueSource(strings = {"1001", "1010", "1100"})
    void setNumberOfPurchasedLottoTicketTest_2(String priceOfPurchasedLottoTicketString) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoUserInput().setNumberOfPurchasedLottoTicket(priceOfPurchasedLottoTicketString))
                .withMessage(LottoStaticConstants.LOTTO_INPUT_NUMBER_NOT_MULTIPLE_OF_THOUSAND_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @Description("수동으로 구매하려는 로또의 수로 소수나 음수가 입력되었을 경우 에러가 발생하는지 테스트.")
    @ValueSource(strings = {"0.1", "1000.5", "-1", "-1000"})
    void setNumberOfManuallyPurchasedLottoTicketTest_1(String numberOfManuallyPurchasedLottoTicketString) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoUserInput().setNumberOfManuallyPurchasedLottoTicket(numberOfManuallyPurchasedLottoTicketString))
                .withMessage(LottoStaticConstants.LOTTO_INPUT_NUMBER_INVALID_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @Description("로또 구입 금액 입력값 보다 수동으로 구매하려는 로또의 수가 많을 경우 에러가 발생하는지 테스트.")
    @ValueSource(strings = {"4", "5", "6"})
    void setNumberOfManuallyPurchasedLottoTicketTest_2(String numberOfManuallyPurchasedLottoTicketString) {
        LottoUserInput lottoUserInput = new LottoUserInput();
        lottoUserInput.setNumberOfPurchasedLottoTicket("3000");

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoUserInput.setNumberOfManuallyPurchasedLottoTicket(numberOfManuallyPurchasedLottoTicketString))
                .withMessage(LottoStaticConstants.LOTTO_INPUT_NUMBER_EXCEED_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @Description("수동으로 구매하려는 로또 번호에 소수나 음수, 특수문자, 문자, 공백 등이 입력되었을 경우 에러가 발생하는지 테스트.")
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6.0", "1, 2, 3, 4, 5, -6", "1, 2, 3, 4, 5, *", "1, 2, 3, 4, 5, A", "1, 2, 3, 4, , 6", "1, 2, 3, 4, 5, , 6"})
    void addManuallyPurchasedLottoTicketsTest_1(String manuallyPurchasedLottoTicketString) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoUserInput().addManuallyPurchasedLottoTicket(manuallyPurchasedLottoTicketString))
                .withMessage(LottoStaticConstants.LOTTO_INPUT_NUMBER_INVALID_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @Description("수동으로 구매하려는 로또 번호에 1 미만 또는 45 초과의 정수가 입력되었을 경우 에러가 발생하는지 테스트.")
    @ValueSource(strings = {"1, 2, 3, 4, 5, 0", "1, 2, 3, 4, 5, 46"})
    void addManuallyPurchasedLottoTicketsTest_2(String manuallyPurchasedLottoTicketString) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoUserInput().addManuallyPurchasedLottoTicket(manuallyPurchasedLottoTicketString))
                .withMessage(LottoStaticConstants.LOTTO_NUMBER_RANGE_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @Description("수동으로 구매하려는 로또 번호가 서로 다른 6개의 숫자로 이루어지지 않은 경우 에러가 발생하는지 테스트.")
    @ValueSource(strings = {"1, 2, 3, 4, 5", "1, 2, 3, 4, 5, 5", "1, 2, 3, 4, 5, 5, 6"})
    void addManuallyPurchasedLottoTicketsTest_3(String manuallyPurchasedLottoTicketString) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoUserInput().addManuallyPurchasedLottoTicket(manuallyPurchasedLottoTicketString))
                .withMessage(LottoStaticConstants.LOTTO_TICKET_NUMBER_SIZE_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @Description("로또 당첨 번호에 소수나 음수, 특수문자, 문자, 공백 등이 입력되었을 경우 에러가 발생하는지 테스트.")
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6.0", "1, 2, 3, 4, 5, -6", "1, 2, 3, 4, 5, *", "1, 2, 3, 4, 5, A", "1, 2, 3, 4, , 6", "1, 2, 3, 4, 5, , 6"})
    void setLottoWinningNumbersTest_1(String lottoWinningNumbersString) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoUserInput().setLottoWinningTicket(lottoWinningNumbersString))
                .withMessage(LottoStaticConstants.LOTTO_INPUT_NUMBER_INVALID_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @Description("로또 당첨 번호에 1 미만 또는 45 초과의 정수가 입력되었을 경우 에러가 발생하는지 테스트.")
    @ValueSource(strings = {"1, 2, 3, 4, 5, 0", "1, 2, 3, 4, 5, 46"})
    void setLottoWinningNumbersTest_2(String lottoWinningNumbersString) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoUserInput().setLottoWinningTicket(lottoWinningNumbersString))
                .withMessage(LottoStaticConstants.LOTTO_NUMBER_RANGE_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @Description("로또 당첨 번호가 서로 다른 6개의 숫자로 이루어지지 않은 경우 에러가 발생하는지 테스트.")
    @ValueSource(strings = {"1, 2, 3, 4, 5", "1, 2, 3, 4, 5, 5", "1, 2, 3, 4, 5, 5, 6"})
    void setLottoWinningNumbersTest_3(String lottoWinningNumbersString) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoUserInput().setLottoWinningTicket(lottoWinningNumbersString))
                .withMessage(LottoStaticConstants.LOTTO_TICKET_NUMBER_SIZE_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @Description("로또 보너스 번호에 소수나 음수, 특수문자, 문자, 공백 등이 입력되었을 경우 에러가 발생하는지 테스트.")
    @ValueSource(strings = {"6.0", "-6", "*", "A", "", "\n"})
    void setBonusNumberTest_1(String bonusNumberString) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoUserInput().setBonusNumber(bonusNumberString))
                .withMessage(LottoStaticConstants.LOTTO_INPUT_NUMBER_INVALID_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @Description("로또 보너스 번호에 1 미만 또는 45 초과의 정수가 입력되었을 경우 에러가 발생하는지 테스트.")
    @ValueSource(strings = {"0", "46"})
    void setBonusNumberTest_2(String bonusNumberString) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoUserInput().setBonusNumber(bonusNumberString))
                .withMessage(LottoStaticConstants.LOTTO_NUMBER_RANGE_ERROR_MESSAGE);
    }
}