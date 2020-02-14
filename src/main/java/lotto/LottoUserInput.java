package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoUserInput {
    private int numberOfPurchasedLottoTicket;
    private int numberOfManuallyPurchasedLottoTicket;
    private LottoTickets manuallyPurchasedLottoTickets = new LottoTickets();
    private LottoTicket lottoWinningTicket;
    private LottoNumber bonusNumber;

    public void setNumberOfPurchasedLottoTicket(String priceOfPurchasedLottoTicketString) {
        int priceOfPurchasedLottoTicket = parseStringToPositiveInteger(priceOfPurchasedLottoTicketString);
        if (priceOfPurchasedLottoTicket % LottoStaticConstants.LOTTO_TICKET_PRICE != 0) {
            throw new IllegalArgumentException(LottoStaticConstants.LOTTO_INPUT_NUMBER_NOT_MULTIPLE_OF_THOUSAND_ERROR_MESSAGE);
        }

        if (priceOfPurchasedLottoTicket == 0) {
            System.out.println(LottoStaticConstants.LOTTO_INPUT_NUMBER_ZERO_MESSAGE);
            System.exit(0);
        }

        this.numberOfPurchasedLottoTicket = priceOfPurchasedLottoTicket / LottoStaticConstants.LOTTO_TICKET_PRICE;
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

    public void setLottoWinningTicket(String lottoWinningNumbersString) {
        String[] lottoWinningNumbersStringArray = lottoWinningNumbersString.replace(" ", "")
                .split(LottoStaticConstants.LOTTO_INPUT_DELIMITER);

        List<Integer> lottoWinningNumbersssss = new ArrayList<>(6);
        for (String stringElement : lottoWinningNumbersStringArray) {
            lottoWinningNumbersssss.add(parseStringToPositiveInteger(stringElement));
        }

        LottoMachine lottoMachine = new LottoMachine();
        this.lottoWinningTicket = lottoMachine.generateLottoTicketManually(lottoWinningNumbersssss);
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

    public LottoTickets getResultOfPurchase() {
        LottoTickets purchasedLottoTickets = new LottoTickets();
        purchasedLottoTickets.addAllManuallyPurchasedLottoTickets(this.manuallyPurchasedLottoTickets);

        int numberOfAutomaticallyPurchasedLottoTicket = this.numberOfPurchasedLottoTicket - this.numberOfManuallyPurchasedLottoTicket;
        LottoMachine lottoMachine = new LottoMachine();
        for (int i = 0; i < numberOfAutomaticallyPurchasedLottoTicket; i++) {
            purchasedLottoTickets.addLottoTicket(lottoMachine.generateLottoTicketAutomatically());
        }

        return purchasedLottoTickets;
    }

    public LottoResults getLottoResults(LottoTickets purchasedLottoTickets) {
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(lottoWinningTicket, bonusNumber);
        return purchasedLottoTickets.getLottoResults(lottoWinningNumber);
    }

    public int getNumberOfManuallyPurchasedLottoTicket() {
        return numberOfManuallyPurchasedLottoTicket;
    }
}
