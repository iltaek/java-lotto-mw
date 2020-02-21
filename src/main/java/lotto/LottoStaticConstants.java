package lotto;

public class LottoStaticConstants {
    public static final int LOTTO_TICKET_NUMBER_SIZE = 6;
    public static final int LOTTO_TICKET_PRICE = 1000;

    public static final String LOTTO_INPUT_DELIMITER = ",";

    public static final String LOTTO_TICKET_NUMBER_SIZE_ERROR_MESSAGE = "로또 번호는 서로 다른 숫자로 정확히 6개가 입력되어야 합니다.";
    public static final String LOTTO_NUMBER_RANGE_ERROR_MESSAGE = "로또 번호는 1에서 45 사이로 입력하여야 합니다.";
    public static final String LOTTO_BONUS_NUMBER_EMPTY_ERROR_MESSAGE = "로또 보너스 번호가 입력되지 않았습니다.";
    public static final String LOTTO_BONUS_NUMBER_DUPLICATED_ERROR_MESSAGE = "로또 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.";
    public static final String LOTTO_INPUT_NUMBER_INVALID_ERROR_MESSAGE = "음수가 아닌 정수가 입력되어야 합니다.";
    public static final String LOTTO_INPUT_NUMBER_NOT_MULTIPLE_OF_THOUSAND_ERROR_MESSAGE = "로또 구입 금액은 로또 한 장 가격인 1000원의 배수여야 합니다.";
    public static final String LOTTO_INPUT_NUMBER_EXCEED_ERROR_MESSAGE = "로또 구입 금액을 초과하여 구매할 수 없습니다.";
    public static final String LOTTO_INPUT_NUMBER_ZERO_MESSAGE = "로또를 구매하지 않아 프로그램을 종료합니다.";
}
