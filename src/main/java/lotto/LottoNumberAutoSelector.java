package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LottoNumberAutoSelector {

    private static List<LottoNumber> lottoNumbers = new ArrayList<>();

    static {
        for (int i = 1; i <= 45; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }
    }

    public static LottoPaper autoMarking() {
        LottoPaper lottoPaper = new LottoPaper(true, getRandomLottoNumbers());
        return lottoPaper;
    }

    private static LottoNumber[] getRandomLottoNumbers() {
        LottoNumber[] selectedRandomNumbers = new LottoNumber[6];

        List<LottoNumber> lottoNumbers = new ArrayList<>();
        numbers.addAll(lottoNumbers);

        Random randomNumberGenerator = new Random();
        for (int i = 0; i < 6; i++) {
            selectedRandomNumbers[i] = numbers
                .remove((randomNumberGenerator.nextInt(45) % (numbers.size())));
        }

        return selectedRandomNumbers;
    }
}
