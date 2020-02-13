package lotto;

import com.sun.org.glassfish.gmbal.Description;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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

        LottoNumber[] lottoNumbers_1 = {LottoNumber.LOTTO_NUMBER_1, LottoNumber.LOTTO_NUMBER_2, LottoNumber.LOTTO_NUMBER_3, LottoNumber.LOTTO_NUMBER_4, LottoNumber.LOTTO_NUMBER_5, LottoNumber.LOTTO_NUMBER_6};
        LottoNumber[] lottoNumbers_2 = {LottoNumber.LOTTO_NUMBER_10, LottoNumber.LOTTO_NUMBER_11, LottoNumber.LOTTO_NUMBER_12, LottoNumber.LOTTO_NUMBER_13, LottoNumber.LOTTO_NUMBER_14, LottoNumber.LOTTO_NUMBER_15};
        LottoNumber[] lottoNumbers_3 = {LottoNumber.LOTTO_NUMBER_20, LottoNumber.LOTTO_NUMBER_21, LottoNumber.LOTTO_NUMBER_22, LottoNumber.LOTTO_NUMBER_23, LottoNumber.LOTTO_NUMBER_24, LottoNumber.LOTTO_NUMBER_25};
        LottoNumber[] lottoNumbers_4 = {LottoNumber.LOTTO_NUMBER_30, LottoNumber.LOTTO_NUMBER_31, LottoNumber.LOTTO_NUMBER_32, LottoNumber.LOTTO_NUMBER_33, LottoNumber.LOTTO_NUMBER_34, LottoNumber.LOTTO_NUMBER_35};
        LottoNumber[] lottoNumbers_5 = {LottoNumber.LOTTO_NUMBER_40, LottoNumber.LOTTO_NUMBER_41, LottoNumber.LOTTO_NUMBER_42, LottoNumber.LOTTO_NUMBER_43, LottoNumber.LOTTO_NUMBER_44, LottoNumber.LOTTO_NUMBER_45};

        LottoTicket lottoTicket_1 = new LottoTicket(Arrays.asList(lottoNumbers_1));
        LottoTicket lottoTicket_2 = new LottoTicket(Arrays.asList(lottoNumbers_2));
        LottoTicket lottoTicket_3 = new LottoTicket(Arrays.asList(lottoNumbers_3));
        LottoTicket lottoTicket_4 = new LottoTicket(Arrays.asList(lottoNumbers_4));
        LottoTicket lottoTicket_5 = new LottoTicket(Arrays.asList(lottoNumbers_5));

        lottoTickets.addLottoTicket(lottoTicket_1);
        lottoTickets.addLottoTicket(lottoTicket_2);
        lottoTickets.addLottoTicket(lottoTicket_3);
        lottoTickets.addLottoTicket(lottoTicket_4);
        lottoTickets.addLottoTicket(lottoTicket_5);
    }

    private static void generateLottoResults() {
        LottoNumber[] winningLottoNumbers = {LottoNumber.LOTTO_NUMBER_1, LottoNumber.LOTTO_NUMBER_2, LottoNumber.LOTTO_NUMBER_3, LottoNumber.LOTTO_NUMBER_10, LottoNumber.LOTTO_NUMBER_11, LottoNumber.LOTTO_NUMBER_20};
        WinningLottoNumber winningLottoNumber = new WinningLottoNumber(Arrays.asList(winningLottoNumbers), LottoNumber.LOTTO_NUMBER_30);

        lottoResults = lottoTickets.getLottoResults(winningLottoNumber);
    }

    @Test
    @Description("로또 구매 완료 후 구매 내역이 정리되어 출력되는 것을 확인할 수 있는 테스트.")
    void printResultOfPurchaseTest() {
        new LottoOutputPrinter().printResultOfPurchase(lottoTickets, 2);
    }

    @Test
    @Description("로또 구매 완료 후 당첨 내역이 정리되어 출력되는 것을 확인할 수 있는 테스트.")
    void printResultOfStatisticsTest() {
        new LottoOutputPrinter().printResultOfStatistics(lottoResults);

        assertEquals(1.0, lottoResults.getRateOfReturn());
    }
}