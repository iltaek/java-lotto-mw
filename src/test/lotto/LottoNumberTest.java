package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {
    @Test
    public void equalityTest() {
        assertEquals(new LottoNumber(3), new LottoNumber(3));
    }

    @ParameterizedTest
    @CsvSource({"0", "46"})
    public void illegalNumberTest(int number) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoNumber(number))
                .withMessageContaining(LottoNumber.INVALID_NUMBER_MESSAGE);
    }
}