package lotto;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    static final String INVALID_NUMBER_MESSAGE = "로또 번호로 입력할 수 없는 수입니다.";

    private final int number;

    public LottoNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(INVALID_NUMBER_MESSAGE);
        }
        this.number = number;
    }


    @Override
    public int compareTo(LottoNumber lottoNumber) {
        return this.number - lottoNumber.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        return this.compareTo((LottoNumber) object) == 0;
    }
}
