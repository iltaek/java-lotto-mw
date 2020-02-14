package lotto;

import com.sun.org.glassfish.gmbal.Description;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoUserInputTest {

    @ParameterizedTest
    @Description("�ζ� ���� �ݾ����� �Ҽ��� ������ �ԷµǾ��� ��� ������ �߻��ϴ��� �׽�Ʈ.")
    @ValueSource(strings = {"0.1", "1000.5", "-1", "-1000"})
    void setNumberOfPurchasedLottoTicketTest_1(String priceOfPurchasedLottoTicketString) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoUserInput().setNumberOfPurchasedLottoTicket(priceOfPurchasedLottoTicketString))
                .withMessage(LottoStaticConstants.LOTTO_INPUT_NUMBER_INVALID_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @Description("�ζ� ���� �ݾ����� 1000���� ����� �ƴ� ���� �ԷµǾ��� ��� ������ �߻��ϴ��� �׽�Ʈ.")
    @ValueSource(strings = {"1001", "1010", "1100"})
    void setNumberOfPurchasedLottoTicketTest_2(String priceOfPurchasedLottoTicketString) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoUserInput().setNumberOfPurchasedLottoTicket(priceOfPurchasedLottoTicketString))
                .withMessage(LottoStaticConstants.LOTTO_INPUT_NUMBER_NOT_MULTIPLE_OF_THOUSAND_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @Description("�������� �����Ϸ��� �ζ��� ���� �Ҽ��� ������ �ԷµǾ��� ��� ������ �߻��ϴ��� �׽�Ʈ.")
    @ValueSource(strings = {"0.1", "1000.5", "-1", "-1000"})
    void setNumberOfManuallyPurchasedLottoTicketTest_1(String numberOfManuallyPurchasedLottoTicketString) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoUserInput().setNumberOfManuallyPurchasedLottoTicket(numberOfManuallyPurchasedLottoTicketString))
                .withMessage(LottoStaticConstants.LOTTO_INPUT_NUMBER_INVALID_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @Description("�ζ� ���� �ݾ� �Է°� ���� �������� �����Ϸ��� �ζ��� ���� ���� ��� ������ �߻��ϴ��� �׽�Ʈ.")
    @ValueSource(strings = {"4", "5", "6"})
    void setNumberOfManuallyPurchasedLottoTicketTest_2(String numberOfManuallyPurchasedLottoTicketString) {
        LottoUserInput lottoUserInput = new LottoUserInput();
        lottoUserInput.setNumberOfPurchasedLottoTicket("3000");

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoUserInput.setNumberOfManuallyPurchasedLottoTicket(numberOfManuallyPurchasedLottoTicketString))
                .withMessage(LottoStaticConstants.LOTTO_INPUT_NUMBER_EXCEED_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @Description("�������� �����Ϸ��� �ζ� ��ȣ�� �Ҽ��� ����, Ư������, ����, ���� ���� �ԷµǾ��� ��� ������ �߻��ϴ��� �׽�Ʈ.")
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6.0", "1, 2, 3, 4, 5, -6", "1, 2, 3, 4, 5, *", "1, 2, 3, 4, 5, A", "1, 2, 3, 4, , 6", "1, 2, 3, 4, 5, , 6"})
    void addManuallyPurchasedLottoTicketsTest_1(String manuallyPurchasedLottoTicketString) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoUserInput().addManuallyPurchasedLottoTicket(manuallyPurchasedLottoTicketString))
                .withMessage(LottoStaticConstants.LOTTO_INPUT_NUMBER_INVALID_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @Description("�������� �����Ϸ��� �ζ� ��ȣ�� 1 �̸� �Ǵ� 45 �ʰ��� ������ �ԷµǾ��� ��� ������ �߻��ϴ��� �׽�Ʈ.")
    @ValueSource(strings = {"1, 2, 3, 4, 5, 0", "1, 2, 3, 4, 5, 46"})
    void addManuallyPurchasedLottoTicketsTest_2(String manuallyPurchasedLottoTicketString) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoUserInput().addManuallyPurchasedLottoTicket(manuallyPurchasedLottoTicketString))
                .withMessage(LottoStaticConstants.LOTTO_NUMBER_RANGE_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @Description("�������� �����Ϸ��� �ζ� ��ȣ�� ���� �ٸ� 6���� ���ڷ� �̷������ ���� ��� ������ �߻��ϴ��� �׽�Ʈ.")
    @ValueSource(strings = {"1, 2, 3, 4, 5", "1, 2, 3, 4, 5, 5", "1, 2, 3, 4, 5, 5, 6"})
    void addManuallyPurchasedLottoTicketsTest_3(String manuallyPurchasedLottoTicketString) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoUserInput().addManuallyPurchasedLottoTicket(manuallyPurchasedLottoTicketString))
                .withMessage(LottoStaticConstants.LOTTO_TICKET_NUMBER_SIZE_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @Description("�ζ� ��÷ ��ȣ�� �Ҽ��� ����, Ư������, ����, ���� ���� �ԷµǾ��� ��� ������ �߻��ϴ��� �׽�Ʈ.")
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6.0", "1, 2, 3, 4, 5, -6", "1, 2, 3, 4, 5, *", "1, 2, 3, 4, 5, A", "1, 2, 3, 4, , 6", "1, 2, 3, 4, 5, , 6"})
    void setLottoWinningNumbersTest_1(String lottoWinningNumbersString) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoUserInput().setLottoWinningTicket(lottoWinningNumbersString))
                .withMessage(LottoStaticConstants.LOTTO_INPUT_NUMBER_INVALID_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @Description("�ζ� ��÷ ��ȣ�� 1 �̸� �Ǵ� 45 �ʰ��� ������ �ԷµǾ��� ��� ������ �߻��ϴ��� �׽�Ʈ.")
    @ValueSource(strings = {"1, 2, 3, 4, 5, 0", "1, 2, 3, 4, 5, 46"})
    void setLottoWinningNumbersTest_2(String lottoWinningNumbersString) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoUserInput().setLottoWinningTicket(lottoWinningNumbersString))
                .withMessage(LottoStaticConstants.LOTTO_NUMBER_RANGE_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @Description("�ζ� ��÷ ��ȣ�� ���� �ٸ� 6���� ���ڷ� �̷������ ���� ��� ������ �߻��ϴ��� �׽�Ʈ.")
    @ValueSource(strings = {"1, 2, 3, 4, 5", "1, 2, 3, 4, 5, 5", "1, 2, 3, 4, 5, 5, 6"})
    void setLottoWinningNumbersTest_3(String lottoWinningNumbersString) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoUserInput().setLottoWinningTicket(lottoWinningNumbersString))
                .withMessage(LottoStaticConstants.LOTTO_TICKET_NUMBER_SIZE_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @Description("�ζ� ���ʽ� ��ȣ�� �Ҽ��� ����, Ư������, ����, ���� ���� �ԷµǾ��� ��� ������ �߻��ϴ��� �׽�Ʈ.")
    @ValueSource(strings = {"6.0", "-6", "*", "A", "", "\n"})
    void setBonusNumberTest_1(String bonusNumberString) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoUserInput().setBonusNumber(bonusNumberString))
                .withMessage(LottoStaticConstants.LOTTO_INPUT_NUMBER_INVALID_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @Description("�ζ� ���ʽ� ��ȣ�� 1 �̸� �Ǵ� 45 �ʰ��� ������ �ԷµǾ��� ��� ������ �߻��ϴ��� �׽�Ʈ.")
    @ValueSource(strings = {"0", "46"})
    void setBonusNumberTest_2(String bonusNumberString) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoUserInput().setBonusNumber(bonusNumberString))
                .withMessage(LottoStaticConstants.LOTTO_NUMBER_RANGE_ERROR_MESSAGE);
    }
}