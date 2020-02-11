package lotto;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class LottoNumber {

    private int selectedNumber;

    private static Map<Integer, LottoNumber> cachedLottoNumber = new HashMap<>();

    static {
        for (int i = 0; i < 45; i++) {
            cachedLottoNumber.put(i+1, new LottoNumber(i+1));
        }
    }

    private LottoNumber(int selectedNumber) {
        this.selectedNumber = selectedNumber;
    }

    static LottoNumber of(int selectedNumber) {
        if (selectedNumber < 0 || selectedNumber > 45) {
            throw new IllegalArgumentException("로또 번호는 1~45 사이의 수만 입력 가능합니다.");
        }
        return cachedLottoNumber.get(selectedNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return selectedNumber == that.selectedNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(selectedNumber);
    }

    @Override
    public String toString(){
        return Integer.toString(selectedNumber);
    }
}
