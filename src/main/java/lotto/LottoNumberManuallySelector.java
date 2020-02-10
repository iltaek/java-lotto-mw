package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoNumberManuallySelector {

    static final String DELIMITER = ",";

    public static LottoPaper marking(String userInput4ManuallySelectNumbers) {
        String[] manuallySelectedNumberStrArray = userInput4ManuallySelectNumbers.split(DELIMITER);

        UserInputValidator.validateSelectedSixNumbers(manuallySelectedNumberStrArray);

        List<LottoNumber> lottoNumbers = convertStrArrayToLottoNumberArray(
            manuallySelectedNumberStrArray);

        LottoPaper lottoPaper = new LottoPaper(false, lottoNumbers);

        return lottoPaper;
    }

    private static List<LottoNumber> convertStrArrayToLottoNumberArray(String[] strArray) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < strArray.length; i++) {
            lottoNumbers.add(new LottoNumber(Integer.parseInt(strArray[i])));
        }

        return lottoNumbers;
    }

}
