package lotto;

import com.sun.org.glassfish.gmbal.Description;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {

    @ParameterizedTest
    @Description("구입한 로또 티켓과 로또 당첨 번호를 파라미터로 전달하였을 때 로또 당첨 결과를 올바르게 알려주는지 테스트.")
    @MethodSource("getLottoResultTestData")
    void getLottoResultTest(LottoTicket candidateLottoTicket, LottoWinningNumber lottoWinningNumber, LottoResult expectedLottoResult) {
        LottoResult actualLottoResult = new LottoResultDetector().getLottoResult(candidateLottoTicket, lottoWinningNumber);
        assertEquals(expectedLottoResult, actualLottoResult);
    }

    private static Stream<Arguments> getLottoResultTestData() {
        LottoNumber[] lottoNumbers_ExpectingNoPrize_1 = {LottoNumber.LOTTO_NUMBER_40, LottoNumber.LOTTO_NUMBER_41, LottoNumber.LOTTO_NUMBER_42, LottoNumber.LOTTO_NUMBER_43, LottoNumber.LOTTO_NUMBER_44, LottoNumber.LOTTO_NUMBER_45};
        LottoNumber[] lottoNumbers_ExpectingNoPrize_2 = {LottoNumber.LOTTO_NUMBER_7, LottoNumber.LOTTO_NUMBER_41, LottoNumber.LOTTO_NUMBER_42, LottoNumber.LOTTO_NUMBER_43, LottoNumber.LOTTO_NUMBER_44, LottoNumber.LOTTO_NUMBER_45};
        LottoNumber[] lottoNumbers_ExpectingNoPrize_3 = {LottoNumber.LOTTO_NUMBER_1, LottoNumber.LOTTO_NUMBER_41, LottoNumber.LOTTO_NUMBER_42, LottoNumber.LOTTO_NUMBER_43, LottoNumber.LOTTO_NUMBER_44, LottoNumber.LOTTO_NUMBER_45};
        LottoNumber[] lottoNumbers_ExpectingNoPrize_4 = {LottoNumber.LOTTO_NUMBER_1, LottoNumber.LOTTO_NUMBER_2, LottoNumber.LOTTO_NUMBER_42, LottoNumber.LOTTO_NUMBER_43, LottoNumber.LOTTO_NUMBER_44, LottoNumber.LOTTO_NUMBER_45};
        LottoNumber[] lottoNumbers_ExpectingFifthPrize = {LottoNumber.LOTTO_NUMBER_1, LottoNumber.LOTTO_NUMBER_2, LottoNumber.LOTTO_NUMBER_3, LottoNumber.LOTTO_NUMBER_43, LottoNumber.LOTTO_NUMBER_44, LottoNumber.LOTTO_NUMBER_45};
        LottoNumber[] lottoNumbers_ExpectingFourthPrize = {LottoNumber.LOTTO_NUMBER_1, LottoNumber.LOTTO_NUMBER_2, LottoNumber.LOTTO_NUMBER_3, LottoNumber.LOTTO_NUMBER_4, LottoNumber.LOTTO_NUMBER_44, LottoNumber.LOTTO_NUMBER_45};
        LottoNumber[] lottoNumbers_ExpectingThridPrize = {LottoNumber.LOTTO_NUMBER_1, LottoNumber.LOTTO_NUMBER_2, LottoNumber.LOTTO_NUMBER_3, LottoNumber.LOTTO_NUMBER_4, LottoNumber.LOTTO_NUMBER_5, LottoNumber.LOTTO_NUMBER_45};
        LottoNumber[] lottoNumbers_ExpectingSecondPrize = {LottoNumber.LOTTO_NUMBER_1, LottoNumber.LOTTO_NUMBER_2, LottoNumber.LOTTO_NUMBER_3, LottoNumber.LOTTO_NUMBER_4, LottoNumber.LOTTO_NUMBER_5, LottoNumber.LOTTO_NUMBER_7};
        LottoNumber[] lottoNumbers_ExpectingFirstPrize = {LottoNumber.LOTTO_NUMBER_1, LottoNumber.LOTTO_NUMBER_2, LottoNumber.LOTTO_NUMBER_3, LottoNumber.LOTTO_NUMBER_4, LottoNumber.LOTTO_NUMBER_5, LottoNumber.LOTTO_NUMBER_6};

        LottoTicket candidateLottoTicket_ExpectingNoPrize_1 = new LottoTicket(Arrays.asList(lottoNumbers_ExpectingNoPrize_1));
        LottoTicket candidateLottoTicket_ExpectingNoPrize_2 = new LottoTicket(Arrays.asList(lottoNumbers_ExpectingNoPrize_2));
        LottoTicket candidateLottoTicket_ExpectingNoPrize_3 = new LottoTicket(Arrays.asList(lottoNumbers_ExpectingNoPrize_3));
        LottoTicket candidateLottoTicket_ExpectingNoPrize_4 = new LottoTicket(Arrays.asList(lottoNumbers_ExpectingNoPrize_4));
        LottoTicket candidateLottoTicket_ExpectingFifthPrize = new LottoTicket(Arrays.asList(lottoNumbers_ExpectingFifthPrize));
        LottoTicket candidateLottoTicket_ExpectingFourthPrize = new LottoTicket(Arrays.asList(lottoNumbers_ExpectingFourthPrize));
        LottoTicket candidateLottoTicket_ExpectingThridPrize = new LottoTicket(Arrays.asList(lottoNumbers_ExpectingThridPrize));
        LottoTicket candidateLottoTicket_ExpectingSecondPrize = new LottoTicket(Arrays.asList(lottoNumbers_ExpectingSecondPrize));
        LottoTicket candidateLottoTicket_ExpectingFirstPrize = new LottoTicket(Arrays.asList(lottoNumbers_ExpectingFirstPrize));

        LottoNumber[] lottoWinningNumbersInArray = {LottoNumber.LOTTO_NUMBER_1, LottoNumber.LOTTO_NUMBER_2, LottoNumber.LOTTO_NUMBER_3, LottoNumber.LOTTO_NUMBER_4, LottoNumber.LOTTO_NUMBER_5, LottoNumber.LOTTO_NUMBER_6};
        List<LottoNumber> lottoWinningNumbers = Arrays.asList(lottoWinningNumbersInArray);
        LottoTicket lottoWinningTicket = new LottoTicket(lottoWinningNumbers);
        LottoNumber bonusNumber = LottoNumber.LOTTO_NUMBER_7;
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(lottoWinningTicket, bonusNumber);

        return Stream.of(
                Arguments.of(candidateLottoTicket_ExpectingNoPrize_1, lottoWinningNumber, LottoResult.NO_PRIZE),
                Arguments.of(candidateLottoTicket_ExpectingNoPrize_2, lottoWinningNumber, LottoResult.NO_PRIZE),
                Arguments.of(candidateLottoTicket_ExpectingNoPrize_3, lottoWinningNumber, LottoResult.NO_PRIZE),
                Arguments.of(candidateLottoTicket_ExpectingNoPrize_4, lottoWinningNumber, LottoResult.NO_PRIZE),
                Arguments.of(candidateLottoTicket_ExpectingFifthPrize, lottoWinningNumber, LottoResult.FIFTH_PRIZE),
                Arguments.of(candidateLottoTicket_ExpectingFourthPrize, lottoWinningNumber, LottoResult.FOURTH_PRIZE),
                Arguments.of(candidateLottoTicket_ExpectingThridPrize, lottoWinningNumber, LottoResult.THIRD_PRIZE),
                Arguments.of(candidateLottoTicket_ExpectingSecondPrize, lottoWinningNumber, LottoResult.SECOND_PRIZE),
                Arguments.of(candidateLottoTicket_ExpectingFirstPrize, lottoWinningNumber, LottoResult.FIRST_PRIZE)
        );
    }
}