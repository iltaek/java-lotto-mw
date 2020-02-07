package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LottoNumberAutoSelector {

    private int[][] autoSelectedNumbers;
    private List<Integer> lottoNumbers = new ArrayList<>();

    public LottoNumberAutoSelector(int autoSelectCount) {
        autoSelectedNumbers = new int[autoSelectCount][6];
        for (int i = 1; i <= 45; i++) {
            lottoNumbers.add(i);
        }
    }

    private int[] getRandomNumbers() {
        int[] selectedRandomNumbers = new int[6];

        Random randomNumberGenerator = new Random();
        List<Integer> numbers = new ArrayList<>();
        numbers.addAll(lottoNumbers);

        for (int i = 0; i < 6; i++) {
            selectedRandomNumbers[i] = numbers
                .remove((randomNumberGenerator.nextInt(45) % (selectedRandomNumbers.length)));
        }

        return selectedRandomNumbers;
    }

    public int[][] getAutoSelectedNumbers() {
        for (int i = 0; i < autoSelectedNumbers.length; i++) {
            autoSelectedNumbers[i] = getRandomNumbers();
        }
        return autoSelectedNumbers;
    }
}
