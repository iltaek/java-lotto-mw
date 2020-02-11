package lotto;

import com.sun.org.glassfish.gmbal.Description;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LottoMachineTest {

    @RepeatedTest(10)
    @Description("로또 기계에서 로또 티켓을 한 장 자동 생성하는 동작을 여러 번 반복 시행하며, 생성 된 로또 티켓들에 문제가 없는지 테스트.")
    void generateLottoTicketAutomaticallyTest(RepetitionInfo repetitionInfo) {
        LottoTicket lottoTicket = new LottoMachine().generateLottoTicketAutomatically();
        System.out.println("Automatically generated LottoTicket " + repetitionInfo.getCurrentRepetition() + " : " + lottoTicket);

        String[] strings = lottoTicket.toString()
                .split(" ");

        assertEquals(6, strings.length);
    }

    @ParameterizedTest
    @Description("로또 기계에서 로또 티켓을 한 장 수동 생성하기 위해 파라미터로 전달되는 번호 List가 null인 경우 에러가 발생하는지 테스트.")
    @NullAndEmptySource
    void generateLottoTicketManually_NullInputTest(List<Integer> manuallyChosenNumbers) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoMachine().generateLottoTicketManually(manuallyChosenNumbers))
                .withMessage(LottoStaticConstants.LOTTO_TICKET_NUMBER_SIZE_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @Description("로또 기계에서 로또 티켓을 한 장 수동 생성하기 위해 파라미터로 전달되는 숫자 List에 로또 번호로서 유효하지 않은 값이 포함되어 있는 경우 에러를 발생하는지 테스트.")
    @MethodSource("generateLottoTicketManually_InvalidLottoNumberTestData")
    void generateLottoTicketManually_InvalidLottoNumberTest(List<Integer> manuallyChosenNumbers) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoMachine().generateLottoTicketManually(manuallyChosenNumbers))
                .withMessage(LottoStaticConstants.LOTTO_NUMBER_RANGE_ERROR_MESSAGE);
    }

    private static Stream<Arguments> generateLottoTicketManually_InvalidLottoNumberTestData() {
        Integer[] integersWithInvalidLottoNumber_1 = {-1, 2, 3, 4, 5, 6};
        Integer[] integersWithInvalidLottoNumber_2 = {0, 1, 2, 3, 4, 5};
        Integer[] integersWithInvalidLottoNumber_3 = {41, 42, 43, 44, 45, 46};

        return Stream.of(
                Arguments.of(Arrays.asList(integersWithInvalidLottoNumber_1)),
                Arguments.of(Arrays.asList(integersWithInvalidLottoNumber_2)),
                Arguments.of(Arrays.asList(integersWithInvalidLottoNumber_3))
        );
    }

    @ParameterizedTest
    @Description("로또 기계에서 로또 티켓을 한 장 수동 생성하기 위해 파라미터로 전달되는 숫자 List의 다양한 값에 대해 올바르게 동작하는지 테스트.")
    @MethodSource("generateLottoTicketManuallyTestData")
    void generateLottoTicketManuallyTest(boolean isErrorExpected, List<Integer> manuallyChosenNumbers) {
        if (isErrorExpected) {
            Assertions.assertThatIllegalArgumentException()
                    .isThrownBy(() -> new LottoMachine().generateLottoTicketManually(manuallyChosenNumbers))
                    .withMessage(LottoStaticConstants.LOTTO_TICKET_NUMBER_SIZE_ERROR_MESSAGE);

            return;
        }

        new LottoMachine().generateLottoTicketManually(manuallyChosenNumbers);
    }

    private static Stream<Arguments> generateLottoTicketManuallyTestData() {
        Integer[] integersWithSize5AndDuplicates0 = {1, 2, 3, 4, 5};
        Integer[] integersWithSize6AndDuplicates0 = {1, 2, 3, 4, 5, 6};
        Integer[] integersWithSize7AndDuplicates0 = {1, 2, 3, 4, 5, 6, 7};

        Integer[] integersWithSize5AndDuplicates2 = {1, 1, 2, 3, 4};
        Integer[] integersWithSize6AndDuplicates2 = {1, 1, 2, 3, 4, 5};
        Integer[] integersWithSize7AndDuplicates2 = {1, 1, 2, 3, 4, 5, 6};

        return Stream.of(
                Arguments.of(true, Arrays.asList(integersWithSize5AndDuplicates0)),
                Arguments.of(false, Arrays.asList(integersWithSize6AndDuplicates0)),
                Arguments.of(true, Arrays.asList(integersWithSize7AndDuplicates0)),

                Arguments.of(true, Arrays.asList(integersWithSize5AndDuplicates2)),
                Arguments.of(true, Arrays.asList(integersWithSize6AndDuplicates2)),
                Arguments.of(true, Arrays.asList(integersWithSize7AndDuplicates2))
        );
    }
}