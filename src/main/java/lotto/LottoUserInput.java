package lotto;

import java.util.*;

public class LottoUserInput {
    private int numberOfPurchasedLottoTicket;
    private int numberOfManuallyPurchasedLottoTicket;
    private LottoTickets manuallyPurchasedLottoTickets = new LottoTickets();
    private List<LottoNumber> lottoWinningNumbers = new ArrayList<>();
    private LottoNumber bonusNumber;

    public void setNumberOfPurchasedLottoTicket(String priceOfLottoTicketPurchasedString) {
        int priceOfLottoTicketPurchased = parseStringToPositiveInteger(priceOfLottoTicketPurchasedString);
        if (priceOfLottoTicketPurchased % LottoStaticConstants.LOTTO_TICKET_PRICE != 0) {
            throw new IllegalArgumentException(LottoStaticConstants.LOTTO_INPUT_NUMBER_NOT_MULTIPLE_OF_THOUSAND_ERROR_MESSAGE);
        }

        if (priceOfLottoTicketPurchased == 0) {
            System.out.println(LottoStaticConstants.LOTTO_INPUT_NUMBER_ZERO_MESSAGE);
            System.exit(0);
        }

        this.numberOfPurchasedLottoTicket = priceOfLottoTicketPurchased / LottoStaticConstants.LOTTO_TICKET_PRICE;
    }

    public void setNumberOfManuallyPurchasedLottoTicket(String numberOfManuallyPurchasedLottoTicketString) {
        int numberOfManuallyPurchasedLottoTicket = parseStringToPositiveInteger(numberOfManuallyPurchasedLottoTicketString);
        if (numberOfManuallyPurchasedLottoTicket > this.numberOfPurchasedLottoTicket) {
            throw new IllegalArgumentException(LottoStaticConstants.LOTTO_INPUT_NUMBER_EXCEED_ERROR_MESSAGE);
        }

        this.numberOfManuallyPurchasedLottoTicket = numberOfManuallyPurchasedLottoTicket;
    }

    public void addManuallyPurchasedLottoTicket(String manuallyPurchasedLottoNumbersString) {
        String[] manuallyPurchasedLottoNumberStringArray = manuallyPurchasedLottoNumbersString.replace(" ", "")
                .split(LottoStaticConstants.LOTTO_INPUT_DELIMITER);

        List<Integer> manuallyPurchasedLottoNumbers = new ArrayList<>(6);
        for (String stringElement : manuallyPurchasedLottoNumberStringArray) {
            manuallyPurchasedLottoNumbers.add(parseStringToPositiveInteger(stringElement));
        }

        LottoMachine lottoMachine = new LottoMachine();
        LottoTicket manuallyPurchasedLottoTicket = lottoMachine.generateLottoTicketManually(manuallyPurchasedLottoNumbers);
        this.manuallyPurchasedLottoTickets.addLottoTicket(manuallyPurchasedLottoTicket);
    }

    public void setLottoWinningNumbers(String lottoWinningNumbersString) {
        String[] lottoWinningNumbersStringArray = lottoWinningNumbersString.replace(" ", "")
                .split(",");

        for (String stringElement : lottoWinningNumbersStringArray) {
            int lottoWinningNumber = parseStringToPositiveInteger(stringElement);

            LottoNumber correspondingLottoNumber = Arrays.stream(LottoNumber.values())
                    .filter(lottoNumber -> lottoNumber.isCorrespondingLottoNumber(lottoWinningNumber))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException(LottoStaticConstants.LOTTO_NUMBER_RANGE_ERROR_MESSAGE));

            lottoWinningNumbers.add(correspondingLottoNumber);
        }

        if (this.lottoWinningNumbers.size() != 6) {
            throw new IllegalArgumentException(LottoStaticConstants.LOTTO_TICKET_NUMBER_SIZE_ERROR_MESSAGE);
        }

        Set<LottoNumber> lottoWinningNumbersWithoutDuplicates = new HashSet<>(lottoWinningNumbers);
        if (lottoWinningNumbersWithoutDuplicates.size() != LottoStaticConstants.LOTTO_TICKET_NUMBER_SIZE) {
            throw new IllegalArgumentException(LottoStaticConstants.LOTTO_TICKET_NUMBER_SIZE_ERROR_MESSAGE);
        }

    }

    public void setBonusNumber(String bonusNumberString) {
        int bonusNumber = parseStringToPositiveInteger(bonusNumberString);

        this.bonusNumber = Arrays.stream(LottoNumber.values())
                .filter(lottoNumber -> lottoNumber.isCorrespondingLottoNumber(bonusNumber))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(LottoStaticConstants.LOTTO_NUMBER_RANGE_ERROR_MESSAGE));
    }

    private int parseStringToPositiveInteger(String string) {
        int positiveInteger;

        try {
            positiveInteger = Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoStaticConstants.LOTTO_INPUT_NUMBER_INVALID_ERROR_MESSAGE);
        }

        if (positiveInteger < 0) {
            throw new IllegalArgumentException(LottoStaticConstants.LOTTO_INPUT_NUMBER_INVALID_ERROR_MESSAGE);
        }

        return positiveInteger;
    }

    public int getNumberOfPurchasedLottoTicket() {
        return numberOfPurchasedLottoTicket;
    }

    public int getNumberOfManuallyPurchasedLottoTicket() {
        return numberOfManuallyPurchasedLottoTicket;
    }

    public LottoTickets getManuallyPurchasedLottoTickets() {
        return manuallyPurchasedLottoTickets;
    }

    public LottoWinningNumber getLottoWinningNumber() {
        return new LottoWinningNumber(lottoWinningNumbers, bonusNumber);
    }
}
