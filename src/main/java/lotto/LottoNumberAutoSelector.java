package lotto;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class LottoNumberAutoSelector {

    private static List<LottoNumber> lottoNumbers = new ArrayList<>();

    static {
        for (int i = 1; i <= 45; i++) {
            lottoNumbers.add(LottoNumber.of(i));
        }
    }

    public static LottoPaper autoMarking() {
        LottoPaper lottoPaper = new LottoPaper(getRandomLottoNumbers());
        return lottoPaper;
    }

    private static Set<LottoNumber> getRandomLottoNumbers() {
        Set<LottoNumber> selectedRandomNumbers = new LinkedHashSet<>();

        List<LottoNumber> tempLottoList = new ArrayList<>();
        tempLottoList.addAll(lottoNumbers);

        Random randomNumberGenerator = new Random();
        for (int i = 0; i < 6; i++) {
            selectedRandomNumbers.add(
                tempLottoList.remove((randomNumberGenerator.nextInt(45) % (tempLottoList.size()))));
        }

        return selectedRandomNumbers;
    }
}
