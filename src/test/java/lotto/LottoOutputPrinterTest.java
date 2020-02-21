package lotto;

import com.sun.org.glassfish.gmbal.Description;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoOutputPrinterTest {
    private static LottoTickets lottoTickets;
    private static LottoResults lottoResults;

    @BeforeAll
    static void prepareTestResources() {
        generateLottoTickets();
        generateLottoResults();
    }

    private static void generateLottoTickets() {
        lottoTickets = new LottoTickets();

        LottoNumber[] manuallyPurchasedLottoNumbers_1 = {LottoNumber.LOTTO_NUMBER_1, LottoNumber.LOTTO_NUMBER_2, LottoNumber.LOTTO_NUMBER_3, LottoNumber.LOTTO_NUMBER_4, LottoNumber.LOTTO_NUMBER_5, LottoNumber.LOTTO_NUMBER_6};
        LottoNumber[] manuallyPurchasedLottoNumbers_2 = {LottoNumber.LOTTO_NUMBER_10, LottoNumber.LOTTO_NUMBER_11, LottoNumber.LOTTO_NUMBER_12, LottoNumber.LOTTO_NUMBER_13, LottoNumber.LOTTO_NUMBER_14, LottoNumber.LOTTO_NUMBER_15};

        LottoTicket manuallyPurchasedLottoTicket_1 = new LottoTicket(Arrays.asList(manuallyPurchasedLottoNumbers_1));
        LottoTicket manuallyPurchasedLottoTicket_2 = new LottoTicket(Arrays.asList(manuallyPurchasedLottoNumbers_2));

        LottoTickets manuallyPurchasedLottoTickets = new LottoTickets();
        manuallyPurchasedLottoTickets.addLottoTicket(manuallyPurchasedLottoTicket_1);
        manuallyPurchasedLottoTickets.addLottoTicket(manuallyPurchasedLottoTicket_2);

        lottoTickets.addAllManuallyPurchasedLottoTickets(manuallyPurchasedLottoTickets);

        LottoNumber[] automaticallyPurchasedLottoNumbers_1 = {LottoNumber.LOTTO_NUMBER_20, LottoNumber.LOTTO_NUMBER_21, LottoNumber.LOTTO_NUMBER_22, LottoNumber.LOTTO_NUMBER_23, LottoNumber.LOTTO_NUMBER_24, LottoNumber.LOTTO_NUMBER_25};
        LottoNumber[] automaticallyPurchasedLottoNumbers_2 = {LottoNumber.LOTTO_NUMBER_30, LottoNumber.LOTTO_NUMBER_31, LottoNumber.LOTTO_NUMBER_32, LottoNumber.LOTTO_NUMBER_33, LottoNumber.LOTTO_NUMBER_34, LottoNumber.LOTTO_NUMBER_35};
        LottoNumber[] automaticallyPurchasedLottoNumbers_3 = {LottoNumber.LOTTO_NUMBER_40, LottoNumber.LOTTO_NUMBER_41, LottoNumber.LOTTO_NUMBER_42, LottoNumber.LOTTO_NUMBER_43, LottoNumber.LOTTO_NUMBER_44, LottoNumber.LOTTO_NUMBER_45};

        LottoTicket automaticallyPurchasedLottoTicket_1 = new LottoTicket(Arrays.asList(automaticallyPurchasedLottoNumbers_1));
        LottoTicket automaticallyPurchasedLottoTicket_2 = new LottoTicket(Arrays.asList(automaticallyPurchasedLottoNumbers_2));
        LottoTicket automaticallyPurchasedLottoTicket_3 = new LottoTicket(Arrays.asList(automaticallyPurchasedLottoNumbers_3));

        lottoTickets.addLottoTicket(automaticallyPurchasedLottoTicket_1);
        lottoTickets.addLottoTicket(automaticallyPurchasedLottoTicket_2);
        lottoTickets.addLottoTicket(automaticallyPurchasedLottoTicket_3);
    }

    private static void generateLottoResults() {
        LottoNumber[] lottoWinningNumbersInArray = {LottoNumber.LOTTO_NUMBER_1, LottoNumber.LOTTO_NUMBER_2, LottoNumber.LOTTO_NUMBER_3, LottoNumber.LOTTO_NUMBER_10, LottoNumber.LOTTO_NUMBER_11, LottoNumber.LOTTO_NUMBER_20};
        List<LottoNumber> lottoWinningNumbers = Arrays.asList(lottoWinningNumbersInArray);
        LottoTicket lottoWinningTicket = new LottoTicket(lottoWinningNumbers);
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(lottoWinningTicket, LottoNumber.LOTTO_NUMBER_30);

        lottoResults = lottoTickets.getLottoResults(lottoWinningNumber);
    }

    @Test
    @Description("로또 구매 완료 후 구매 내역이 정리되어 출력되는 것을 확인할 수 있는 테스트.")
    void printResultOfPurchaseTest() {
        new LottoOutputPrinter().printResultOfPurchase(lottoTickets);
    }

    @Test
    @Description("로또 구매 완료 후 당첨 내역이 정리되어 출력되는 것을 확인할 수 있는 테스트.")
    void printResultOfStatisticsTest() {
        new LottoOutputPrinter().printResultOfStatistics(lottoResults);

        assertEquals(1.0, lottoResults.getRateOfReturn());
    }
}