package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.SelectedNumbers.DUPLICATE_NUMBER_MESSAGE;
import static lotto.SelectedNumbers.SIX_NUMBER_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class SelectedNumbersTest {
    @Test
    @DisplayName("6개의 숫자가 선택되지 않은 경우 예외 처리.")
    public void numberCountExceptionTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new SelectedNumbers(new int[]{1,2,3,4,5}))
                .withMessageContaining(SIX_NUMBER_MESSAGE);
    }

    @Test
    @DisplayName("중복된 숫자를 입력한 경우 예외 처리.")
    public void duplicateNumberExceptionTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new SelectedNumbers(new int[]{1,2,3,4,5,1}))
                .withMessageContaining(DUPLICATE_NUMBER_MESSAGE);
    }

    @Test
    @DisplayName("6개의 선택된 로또 번호 중 몇 개가 중복되는지 체크한다.")
    public void countSameNumberTest() {
        SelectedNumbers a = new SelectedNumbers(new int[]{1,2,3,4,5,6});
        SelectedNumbers b = new SelectedNumbers(new int[]{1,2,3,4,5,45});
        assertEquals(5, a.countDuplicateNumbers(b));
    }
}