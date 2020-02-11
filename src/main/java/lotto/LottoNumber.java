package lotto;

public enum LottoNumber {
    /*
        형식 : 로또_번호_이름(해당하는_번호)
     */
    LOTTO_NUMBER_1(1),
    LOTTO_NUMBER_2(2),
    LOTTO_NUMBER_3(3),
    LOTTO_NUMBER_4(4),
    LOTTO_NUMBER_5(5),
    LOTTO_NUMBER_6(6),
    LOTTO_NUMBER_7(7),
    LOTTO_NUMBER_8(8),
    LOTTO_NUMBER_9(9),
    LOTTO_NUMBER_10(10),
    LOTTO_NUMBER_11(11),
    LOTTO_NUMBER_12(12),
    LOTTO_NUMBER_13(13),
    LOTTO_NUMBER_14(14),
    LOTTO_NUMBER_15(15),
    LOTTO_NUMBER_16(16),
    LOTTO_NUMBER_17(17),
    LOTTO_NUMBER_18(18),
    LOTTO_NUMBER_19(19),
    LOTTO_NUMBER_20(20),
    LOTTO_NUMBER_21(21),
    LOTTO_NUMBER_22(22),
    LOTTO_NUMBER_23(23),
    LOTTO_NUMBER_24(24),
    LOTTO_NUMBER_25(25),
    LOTTO_NUMBER_26(26),
    LOTTO_NUMBER_27(27),
    LOTTO_NUMBER_28(28),
    LOTTO_NUMBER_29(29),
    LOTTO_NUMBER_30(30),
    LOTTO_NUMBER_31(31),
    LOTTO_NUMBER_32(32),
    LOTTO_NUMBER_33(33),
    LOTTO_NUMBER_34(34),
    LOTTO_NUMBER_35(35),
    LOTTO_NUMBER_36(36),
    LOTTO_NUMBER_37(37),
    LOTTO_NUMBER_38(38),
    LOTTO_NUMBER_39(39),
    LOTTO_NUMBER_40(40),
    LOTTO_NUMBER_41(41),
    LOTTO_NUMBER_42(42),
    LOTTO_NUMBER_43(43),
    LOTTO_NUMBER_44(44),
    LOTTO_NUMBER_45(45);

    private int lottoNumber;

    LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public boolean isCorrespondingLottoNumber(int number) {
        return this.lottoNumber == number;
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }
}
