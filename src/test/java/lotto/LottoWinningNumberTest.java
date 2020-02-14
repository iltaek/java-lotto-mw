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
    @Description("로또 당첨 번호와 보너스 번호를 담는 객체를 생성하기 위해 파라미터로 전달되는 로또 당첨 티켓이 null인 경우 에러가 발생하는지 테스트.")
    @NullSource
    void lottoWinningNumbers_NullInputTest(LottoTicket lottoWinningTicket) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoWinningNumber(lottoWinningTicket, LottoNumber.LOTTO_NUMBER_45))
                .withMessage(LottoStaticConstants.LOTTO_TICKET_NUMBER_SIZE_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @Description("로또 당첨 번호와 보너스 번호를 담는 객체를 생성하기 위해 파라미터로 전달되는 로또 보너스 번호가 null인 경우 에러가 발생하는지 테스트.")
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
    @Description("로또 당첨 번호와 보너스 번호를 담는 객체를 생성하기 위해 파라미터로 전달되는 로또 보너스 번호가 로또 당첨 번호와 중복되는 경우 에러가 발생하는지 테스트.")
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