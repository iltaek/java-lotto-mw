package lotto;

import java.util.LinkedHashSet;
import java.util.Set;

public class LottoNumberManuallySelector {

    static final String DELIMITER = ",";

    public static LottoPaper marking(String userInput4ManuallySelectNumbers) {
        String[] manuallySelectedNumberStrArray = userInput4ManuallySelectNumbers.split(DELIMITER);

        UserInputValidator.validateSelectedSixNumbers(manuallySelectedNumberStrArray);

        Set<LottoNumber> lottoNumbers = convertStrArrayToLottoNumberArray(
            manuallySelectedNumberStrArray);

        LottoPaper lottoPaper = new LottoPaper(lottoNumbers);

        return lottoPaper;
    }

    private static Set<LottoNumber> convertStrArrayToLottoNumberArray(String[] strArray) {
        Set<LottoNumber> lottoNumbers = new LinkedHashSet<>();
        for (int i = 0; i < strArray.length; i++) {
            lottoNumbers.add(LottoNumber.of(Integer.parseInt(strArray[i])));
        }

        return lottoNumbers;
    }

}
