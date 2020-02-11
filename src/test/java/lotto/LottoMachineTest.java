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
    @Description("�ζ� ��迡�� �ζ� Ƽ���� �� �� �ڵ� �����ϴ� ������ ���� �� �ݺ� �����ϸ�, ���� �� �ζ� Ƽ�ϵ鿡 ������ ������ �׽�Ʈ.")
    void generateLottoTicketAutomaticallyTest(RepetitionInfo repetitionInfo) {
        LottoTicket lottoTicket = new LottoMachine().generateLottoTicketAutomatically();
        System.out.println("Automatically generated LottoTicket " + repetitionInfo.getCurrentRepetition() + " : " + lottoTicket);

        String[] strings = lottoTicket.toString()
                .split(" ");

        assertEquals(6, strings.length);
    }

    @ParameterizedTest
    @Description("�ζ� ��迡�� �ζ� Ƽ���� �� �� ���� �����ϱ� ���� �Ķ���ͷ� ���޵Ǵ� ��ȣ List�� null�� ��� ������ �߻��ϴ��� �׽�Ʈ.")
    @NullAndEmptySource
    void generateLottoTicketManually_NullInputTest(List<Integer> manuallyChosenNumbers) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoMachine().generateLottoTicketManually(manuallyChosenNumbers))
                .withMessage(LottoStaticConstants.LOTTO_TICKET_NUMBER_SIZE_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @Description("�ζ� ��迡�� �ζ� Ƽ���� �� �� ���� �����ϱ� ���� �Ķ���ͷ� ���޵Ǵ� ���� List�� �ζ� ��ȣ�μ� ��ȿ���� ���� ���� ���ԵǾ� �ִ� ��� ������ �߻��ϴ��� �׽�Ʈ.")
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
    @Description("�ζ� ��迡�� �ζ� Ƽ���� �� �� ���� �����ϱ� ���� �Ķ���ͷ� ���޵Ǵ� ���� List�� �پ��� ���� ���� �ùٸ��� �����ϴ��� �׽�Ʈ.")
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