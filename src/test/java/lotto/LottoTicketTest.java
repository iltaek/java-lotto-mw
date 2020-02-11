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
    @Description("로또 티켓을 생성하기 위해 파라미터로 전달되는 로또 숫자 List가 null인 경우 에러가 발생하는지 테스트.")
    @NullAndEmptySource
    void nullInputTest(List<LottoNumber> lottoNumbers) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoTicket(lottoNumbers))
                .withMessage(LottoStaticConstants.LOTTO_TICKET_NUMBER_SIZE_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @Description("로또 티켓을 생성하기 위해 파라미터로 전달되는 로또 숫자 List가 다양한 크기를 가질 때 올바르게 대처하는지 테스트.")
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
    @Description("로또 티켓을 생성하기 위해 파라미터로 전달되는 로또 숫자 List에 중복 값이 있는 경우 에러가 발생하는지 테스트.")
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