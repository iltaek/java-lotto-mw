package lotto;

import java.util.LinkedHashSet;
import java.util.Set;

public class WinningLottoNumberSelector {

    static final String DELIMITER = ",";

    public static WinningNumbers getWinningNumbers(String input4WinningPaper, int input4BonusNumber) {
        String[] winningNumberStrArray = input4WinningPaper.split(DELIMITER);

        UserInputValidator.validateSelectedSixNumbers(winningNumberStrArray);
        Set<LottoNumber> winningNumberSet = convertStrArrayToLottoNumberArray(
            winningNumberStrArray);

        LottoNumber bonusNumber = LottoNumber.of(input4BonusNumber);

        WinningNumbers winningNumbers = new WinningNumbers(winningNumberSet, bonusNumber);

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
