package lotto;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toSet;

class SelectedNumbers {
    static final String NULL_NUMBER_MESSAGE = "로또 번호가 입력되지 않았습니다.";
    static final String SIX_NUMBER_MESSAGE = "로또 번호는 6개를 선택할 수 있습니다.";
    static final String DUPLICATE_NUMBER_MESSAGE = "중복된 로또 번호가 있습니다.";

    private final Set<LottoNumber> numbers;;

    SelectedNumbers(int[] inputNumbers) {
        if (inputNumbers == null) {
            throw new IllegalArgumentException(NULL_NUMBER_MESSAGE);
        }
        if (inputNumbers.length != 6) {
            throw new IllegalArgumentException(SIX_NUMBER_MESSAGE);
        }

        this.numbers = convertArraysToLottoNumberList(inputNumbers);

        if (numbers.size() != 6) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_MESSAGE);
        }
    }

    private Set<LottoNumber> convertArraysToLottoNumberList(int[] inputNumbers) {
        return Arrays.stream(inputNumbers)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.collectingAndThen(toSet(), Collections::unmodifiableSet));
    }

    int countDuplicateNumbers(SelectedNumbers otherLottoNumbers) {
        return (int) numbers.stream()
                .filter(otherLottoNumbers.numbers::contains)
                .count();
    }

    boolean contains(LottoNumber number) {
        return numbers.contains(number);
    }
}
