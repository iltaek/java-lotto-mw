package lotto;

import com.sun.org.glassfish.gmbal.Description;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class LottoTicketTest {
    @ParameterizedTest
    @Description("�ζ� Ƽ���� �����ϱ� ���� �Ķ���ͷ� ���޵Ǵ� �ζ� ���� List�� null�� ��� ������ �߻��ϴ��� �׽�Ʈ.")
    @NullAndEmptySource
    void nullInputTest(List<LottoNumber> lottoNumbers) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoTicket(lottoNumbers))
                .withMessage(LottoStaticConstants.LOTTO_TICKET_NUMBER_SIZE_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @Description("�ζ� Ƽ���� �����ϱ� ���� �Ķ���ͷ� ���޵Ǵ� �ζ� ���� List�� �پ��� ũ�⸦ ���� �� �ùٸ��� ��ó�ϴ��� �׽�Ʈ.")
    @MethodSource("sizeOfInputTestData")
    void sizeOfInputTest(boolean isErrorExpected, List<LottoNumber> lottoNumbers) {
        if (isErrorExpected) {
            Assertions.assertThatIllegalArgumentException()
                    .isThrownBy(() -> new LottoTicket(lottoNumbers))
                    .withMessage(LottoStaticConstants.LOTTO_TICKET_NUMBER_SIZE_ERROR_MESSAGE);

            return;
        }

        new LottoTicket(lottoNumbers);
    }

    private static Stream<Arguments> sizeOfInputTestData() {
        LottoNumber[] lottoNumbersWithSize5 = {LottoNumber.LOTTO_NUMBER_1, LottoNumber.LOTTO_NUMBER_2, LottoNumber.LOTTO_NUMBER_3, LottoNumber.LOTTO_NUMBER_4, LottoNumber.LOTTO_NUMBER_5};
        LottoNumber[] lottoNumbersWithSize6 = {LottoNumber.LOTTO_NUMBER_1, LottoNumber.LOTTO_NUMBER_2, LottoNumber.LOTTO_NUMBER_3, LottoNumber.LOTTO_NUMBER_4, LottoNumber.LOTTO_NUMBER_5, LottoNumber.LOTTO_NUMBER_6};
        LottoNumber[] lottoNumbersWithSize7 = {LottoNumber.LOTTO_NUMBER_1, LottoNumber.LOTTO_NUMBER_2, LottoNumber.LOTTO_NUMBER_3, LottoNumber.LOTTO_NUMBER_4, LottoNumber.LOTTO_NUMBER_5, LottoNumber.LOTTO_NUMBER_6, LottoNumber.LOTTO_NUMBER_7};

        return Stream.of(
                Arguments.of(true, Arrays.asList(lottoNumbersWithSize5)),
                Arguments.of(false, Arrays.asList(lottoNumbersWithSize6)),
                Arguments.of(true, Arrays.asList(lottoNumbersWithSize7))
        );
    }

    @ParameterizedTest
    @Description("�ζ� Ƽ���� �����ϱ� ���� �Ķ���ͷ� ���޵Ǵ� �ζ� ���� List�� �ߺ� ���� �ִ� ��� ������ �߻��ϴ��� �׽�Ʈ.")
    @MethodSource("duplicatedInputTestData")
    void duplicatedInputTest(List<LottoNumber> lottoNumbers) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoTicket(lottoNumbers))
                .withMessage(LottoStaticConstants.LOTTO_TICKET_NUMBER_SIZE_ERROR_MESSAGE);
    }

    private static Stream<Arguments> duplicatedInputTestData() {
        LottoNumber[] lottoNumbersWithSize5AndDuplicates2 = {LottoNumber.LOTTO_NUMBER_1, LottoNumber.LOTTO_NUMBER_1, LottoNumber.LOTTO_NUMBER_2, LottoNumber.LOTTO_NUMBER_3, LottoNumber.LOTTO_NUMBER_4};
        LottoNumber[] lottoNumbersWithSize6AndDuplicates2 = {LottoNumber.LOTTO_NUMBER_1, LottoNumber.LOTTO_NUMBER_1, LottoNumber.LOTTO_NUMBER_2, LottoNumber.LOTTO_NUMBER_3, LottoNumber.LOTTO_NUMBER_4, LottoNumber.LOTTO_NUMBER_5};
        LottoNumber[] lottoNumbersWithSize7AndDuplicates2 = {LottoNumber.LOTTO_NUMBER_1, LottoNumber.LOTTO_NUMBER_1, LottoNumber.LOTTO_NUMBER_2, LottoNumber.LOTTO_NUMBER_3, LottoNumber.LOTTO_NUMBER_4, LottoNumber.LOTTO_NUMBER_5, LottoNumber.LOTTO_NUMBER_6};

        return Stream.of(
                Arguments.of(Arrays.asList(lottoNumbersWithSize5AndDuplicates2)),
                Arguments.of(Arrays.asList(lottoNumbersWithSize6AndDuplicates2)),
                Arguments.of(Arrays.asList(lottoNumbersWithSize7AndDuplicates2))
        );
    }
}