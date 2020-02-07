package lotto;

public class LottoNumberManuallySelector {
    static final String DELIMITER = ",";

    public static LottoPaper marking(String userInput4ManuallySelectNumbers){
        String[] manuallySelectedNumberStrArray = userInput4ManuallySelectNumbers.split(DELIMITER);

        UserInputValidator.validateSelectedSixNumbers(manuallySelectedNumberStrArray);

        LottoNumber[] lottoNumbers = convertStrArrayToLottoNumberArray(manuallySelectedNumberStrArray);

        LottoPaper lottoPaper = new LottoPaper(false, lottoNumbers);

        return lottoPaper;
    }

    private static LottoNumber[] convertStrArrayToLottoNumberArray (String[] strArray) {
        LottoNumber[] lottoNumbers = new LottoNumber[6];
        for (int i =0 ; i < strArray.length; i++) {
            lottoNumbers[i] = new LottoNumber(Integer.parseInt(strArray[i]));
        }

        return lottoNumbers;
    }

}
