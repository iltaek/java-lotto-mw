package lotto;

import com.sun.org.glassfish.gmbal.Description;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class LottoWinningNumberTest {
    @ParameterizedTest
    @Description("�ζ� ��÷ ��ȣ�� ���ʽ� ��ȣ�� ��� ��ü�� �����ϱ� ���� �Ķ���ͷ� ���޵Ǵ� �ζ� ��÷ Ƽ���� null�� ��� ������ �߻��ϴ��� �׽�Ʈ.")
    @NullSource
    void lottoWinningNumbers_NullInputTest(LottoTicket lottoWinningTicket) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoWinningNumber(lottoWinningTicket, LottoNumber.LOTTO_NUMBER_45))
                .withMessage(LottoStaticConstants.LOTTO_TICKET_NUMBER_SIZE_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @Description("�ζ� ��÷ ��ȣ�� ���ʽ� ��ȣ�� ��� ��ü�� �����ϱ� ���� �Ķ���ͷ� ���޵Ǵ� �ζ� ���ʽ� ��ȣ�� null�� ��� ������ �߻��ϴ��� �׽�Ʈ.")
    @NullSource
    void bonusNumber_NullInputTest(LottoNumber bonusNumber) {
        LottoNumber[] lottoWinningNumbersInArray = {LottoNumber.LOTTO_NUMBER_1, LottoNumber.LOTTO_NUMBER_2, LottoNumber.LOTTO_NUMBER_3, LottoNumber.LOTTO_NUMBER_4, LottoNumber.LOTTO_NUMBER_5, LottoNumber.LOTTO_NUMBER_6};
        List<LottoNumber> lottoWinningNumbers = Arrays.asList(lottoWinningNumbersInArray);
        LottoTicket lottoWinningTicket = new LottoTicket(lottoWinningNumbers);

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoWinningNumber(lottoWinningTicket, bonusNumber))
                .withMessage(LottoStaticConstants.LOTTO_BONUS_NUMBER_EMPTY_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @Description("�ζ� ��÷ ��ȣ�� ���ʽ� ��ȣ�� ��� ��ü�� �����ϱ� ���� �Ķ���ͷ� ���޵Ǵ� �ζ� ���ʽ� ��ȣ�� �ζ� ��÷ ��ȣ�� �ߺ��Ǵ� ��� ������ �߻��ϴ��� �׽�Ʈ.")
    @MethodSource("bonusNumber_DuplicatedInputTestData")
    void bonusNumber_DuplicatedInputTest(LottoNumber bonusNumber) {
        LottoNumber[] lottoWinningNumbersInArray = {LottoNumber.LOTTO_NUMBER_1, LottoNumber.LOTTO_NUMBER_2, LottoNumber.LOTTO_NUMBER_3, LottoNumber.LOTTO_NUMBER_4, LottoNumber.LOTTO_NUMBER_5, LottoNumber.LOTTO_NUMBER_6};
        List<LottoNumber> lottoWinningNumbers = Arrays.asList(lottoWinningNumbersInArray);
        LottoTicket lottoWinningTicket = new LottoTicket(lottoWinningNumbers);

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoWinningNumber(lottoWinningTicket, bonusNumber))
                .withMessage(LottoStaticConstants.LOTTO_BONUS_NUMBER_DUPLICATED_ERROR_MESSAGE);
    }

    private static Stream<Arguments> bonusNumber_DuplicatedInputTestData() {
        return Stream.of(
                Arguments.of(LottoNumber.LOTTO_NUMBER_1),
                Arguments.of(LottoNumber.LOTTO_NUMBER_2),
                Arguments.of(LottoNumber.LOTTO_NUMBER_3),
                Arguments.of(LottoNumber.LOTTO_NUMBER_4),
                Arguments.of(LottoNumber.LOTTO_NUMBER_5),
                Arguments.of(LottoNumber.LOTTO_NUMBER_6)
        );
    }
}