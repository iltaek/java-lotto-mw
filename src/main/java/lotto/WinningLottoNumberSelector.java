package lotto;

import java.util.LinkedHashSet;
import java.util.Set;

public class WinningLottoNumberSelector {

    static final String DELIMITER = ",";

    public static WinningNumbers getWinningNumbers(String input4WinningPaper) {
        String[] winningNumberStrArray = input4WinningPaper.split(DELIMITER);

        UserInputValidator.validateSelectedSevenNumbers(winningNumberStrArray);
        Set<LottoNumber> winningNumberSet = convertStrArrayToLottoNumberArray(
            winningNumberStrArray);

        WinningNumbers winningNumbers = new WinningNumbers(winningNumberSet);

        return winningNumbers;
    }

    private static Set<LottoNumber> convertStrArrayToLottoNumberArray(String[] strArray) {
        Set<LottoNumber> lottoNumbers = new LinkedHashSet<>();
        for (int i = 0; i < strArray.length; i++) {
            lottoNumbers.add(LottoNumber.of(Integer.parseInt(strArray[i])));
        }

        return lottoNumbers;
    }
}
