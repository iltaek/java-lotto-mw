package lotto;

import com.sun.org.glassfish.gmbal.Description;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class WinningLottoNumberTest {
    @ParameterizedTest
    @Description("로또 당첨 번호와 보너스 번호를 담는 객체를 생성하기 위해 파라미터로 전달되는 로또 당첨 번호 List가 null인 경우 에러가 발생하는지 테스트.")
    @NullAndEmptySource
    void winningLottoNumbers_NullInputTest(List<LottoNumber> winningLottoNumbers) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLottoNumber(winningLottoNumbers, LottoNumber.LOTTO_NUMBER_45))
                .withMessage(LottoStaticConstants.LOTTO_TICKET_NUMBER_SIZE_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @Description("로또 당첨 번호와 보너스 번호를 담는 객체를 생성하기 위해 파라미터로 전달되는 로또 당첨 번호 List가 다양한 크기를 가질 때 올바르게 대처하는지 테스트.")
    @MethodSource("winningLottoNumbers_SizeOfInputTestData")
    void winningLottoNumbers_SizeOfInputTest(boolean isErrorExpected, List<LottoNumber> winningLottoNumbers) {
        if (isErrorExpected) {
            Assertions.assertThatIllegalArgumentException()
                    .isThrownBy(() -> new WinningLottoNumber(winningLottoNumbers, LottoNumber.LOTTO_NUMBER_45))
                    .withMessage(LottoStaticConstants.LOTTO_TICKET_NUMBER_SIZE_ERROR_MESSAGE);

            return;
        }

        new WinningLottoNumber(winningLottoNumbers, LottoNumber.LOTTO_NUMBER_45);
    }

    private static Stream<Arguments> winningLottoNumbers_SizeOfInputTestData() {
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
    @Description("로또 당첨 번호와 보너스 번호를 담는 객체를 생성하기 위해 파라미터로 전달되는 로또 당첨 번호 List에 중복 값이 있는 경우 에러가 발생하는지 테스트.")
    @MethodSource("winningLottoNumbers_DuplicatedInputTestData")
    void winningLottoNumbers_DuplicatedInputTest(List<LottoNumber> winningLottoNumbers) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLottoNumber(winningLottoNumbers, LottoNumber.LOTTO_NUMBER_45))
                .withMessage(LottoStaticConstants.LOTTO_TICKET_NUMBER_SIZE_ERROR_MESSAGE);
    }

    private static Stream<Arguments> winningLottoNumbers_DuplicatedInputTestData() {
        LottoNumber[] lottoNumbersWithSize5AndDuplicates2 = {LottoNumber.LOTTO_NUMBER_1, LottoNumber.LOTTO_NUMBER_1, LottoNumber.LOTTO_NUMBER_2, LottoNumber.LOTTO_NUMBER_3, LottoNumber.LOTTO_NUMBER_4};
        LottoNumber[] lottoNumbersWithSize6AndDuplicates2 = {LottoNumber.LOTTO_NUMBER_1, LottoNumber.LOTTO_NUMBER_1, LottoNumber.LOTTO_NUMBER_2, LottoNumber.LOTTO_NUMBER_3, LottoNumber.LOTTO_NUMBER_4, LottoNumber.LOTTO_NUMBER_5};
        LottoNumber[] lottoNumbersWithSize7AndDuplicates2 = {LottoNumber.LOTTO_NUMBER_1, LottoNumber.LOTTO_NUMBER_1, LottoNumber.LOTTO_NUMBER_2, LottoNumber.LOTTO_NUMBER_3, LottoNumber.LOTTO_NUMBER_4, LottoNumber.LOTTO_NUMBER_5, LottoNumber.LOTTO_NUMBER_6};

        return Stream.of(
                Arguments.of(Arrays.asList(lottoNumbersWithSize5AndDuplicates2)),
                Arguments.of(Arrays.asList(lottoNumbersWithSize6AndDuplicates2)),
                Arguments.of(Arrays.asList(lottoNumbersWithSize7AndDuplicates2))
        );
    }

    @ParameterizedTest
    @Description("로또 당첨 번호와 보너스 번호를 담는 객체를 생성하기 위해 파라미터로 전달되는 로또 보너스 번호가 null인 경우 에러가 발생하는지 테스트.")
    @NullSource
    void bonusNumber_NullInputTest(LottoNumber bonusNumber) {
        LottoNumber[] winningLottoNumbersInArray = {LottoNumber.LOTTO_NUMBER_1, LottoNumber.LOTTO_NUMBER_2, LottoNumber.LOTTO_NUMBER_3, LottoNumber.LOTTO_NUMBER_4, LottoNumber.LOTTO_NUMBER_5, LottoNumber.LOTTO_NUMBER_6};
        List<LottoNumber> winningLottoNumbers = Arrays.asList(winningLottoNumbersInArray);

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLottoNumber(winningLottoNumbers, bonusNumber))
                .withMessage(LottoStaticConstants.LOTTO_BONUS_NUMBER_EMPTY_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @Description("로또 당첨 번호와 보너스 번호를 담는 객체를 생성하기 위해 파라미터로 전달되는 로또 보너스 번호가 로또 당첨 번호와 중복되는 경우 에러가 발생하는지 테스트.")
    @MethodSource("bonusNumber_DuplicatedInputTestData")
    void bonusNumber_DuplicatedInputTest(LottoNumber bonusNumber) {
        LottoNumber[] winningLottoNumbersInArray = {LottoNumber.LOTTO_NUMBER_1, LottoNumber.LOTTO_NUMBER_2, LottoNumber.LOTTO_NUMBER_3, LottoNumber.LOTTO_NUMBER_4, LottoNumber.LOTTO_NUMBER_5, LottoNumber.LOTTO_NUMBER_6};
        List<LottoNumber> winningLottoNumbers = Arrays.asList(winningLottoNumbersInArray);

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLottoNumber(winningLottoNumbers, bonusNumber))
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