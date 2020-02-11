package lotto;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoPapers {
    private Map<Prize, Integer> resultMap = new LinkedHashMap<>();

    LottoPapers(){
        resultMap.put(Prize.LOSE_PRIZE, 0);
        resultMap.put(Prize.FIFTH_PRIZE, 0);
        resultMap.put(Prize.FOURTH_PRIZE, 0);
        resultMap.put(Prize.THIRD_PRIZE, 0);
        resultMap.put(Prize.SECOND_PRIZE, 0);
        resultMap.put(Prize.FIRST_PRIZE, 0);
    }

    private List<LottoPaper> lottoPapers = new ArrayList<>();

    public void addLottoPaper(LottoPaper lottoPaper) {
        lottoPapers.add(lottoPaper);
    }

    public List<LottoPaper> getLottoPapers() {
        return lottoPapers;
    }

    public Map<Prize, Integer> matchLottoPaper(WinningNumbers winningNumbers) {
        // 로또 결과를 한장씩 확인
        for (LottoPaper lottoPaper : lottoPapers) {
            Prize result = lottoPaper.matchingCountsLottoNumbers(winningNumbers);
            int occurrence = resultMap.get(result) + 1;
            resultMap.put(result, occurrence);
        }

        return resultMap;
    }
}
