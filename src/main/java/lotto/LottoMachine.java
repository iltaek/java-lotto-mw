package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    public LottoTicket generateLottoTicketAutomatically() {
        List<LottoNumber> lottoNumbers = Arrays.asList(LottoNumber.values());
        Collections.shuffle(lottoNumbers);
        lottoNumbers = lottoNumbers.subList(0, 6);
        Collections.sort(lottoNumbers);

        return new LottoTicket(lottoNumbers);
    }

    public LottoTicket generateLottoTicketManually(List<Integer> manuallyChosenNumbers) {
        if (manuallyChosenNumbers == null) {
            throw new IllegalArgumentException(LottoStaticConstants.LOTTO_TICKET_NUMBER_SIZE_ERROR_MESSAGE);
        }

        List<LottoNumber> lottoNumbers = new ArrayList<>(6);

        for (Integer manuallyChosenNumber : manuallyChosenNumbers) {
            LottoNumber correspondingLottoNumber = Arrays.stream(LottoNumber.values())
                    .filter(lottoNumber -> lottoNumber.isCorrespondingLottoNumber(manuallyChosenNumber))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException(LottoStaticConstants.LOTTO_NUMBER_RANGE_ERROR_MESSAGE));

            lottoNumbers.add(correspondingLottoNumber);
        }

        return new LottoTicket(lottoNumbers);
    }
}
