package lotto;

public class LottoNumber {
    int selectedNumber;
    LottoNumber(int selectedNumber) {
        if ( selectedNumber < 0 || selectedNumber > 45) {
            throw new IllegalArgumentException("로또 번호는 1~45 사이의 수만 입력 가능합니다.");
        }
        this.selectedNumber = selectedNumber;
    }

}
