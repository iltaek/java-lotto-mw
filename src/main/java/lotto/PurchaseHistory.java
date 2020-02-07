package lotto;

public class PurchaseHistory {

    public static void print(int[][] manuallySelectedNumbersArray,
        int[][] autoSelectedNumbersArray) {
        System.out.println(
            "수동으로 " + manuallySelectedNumbersArray.length + "장, 자동으로 "
                + autoSelectedNumbersArray.length
                + "개를 구매했습니다.");

        for (int[] manuallySelectedNumbers : manuallySelectedNumbersArray) {
            internalPrint(manuallySelectedNumbers);
        }
        for (int[] autoSelectedNumbers : autoSelectedNumbersArray) {
            internalPrint(autoSelectedNumbers);
        }
    }

    private static void internalPrint(int[] intArray) {
        String buf = "[";
        for (int numbers : intArray) {
            buf += numbers + ",";
        }
        System.out.println(buf.substring(0, buf.length() - 1) + "]");
    }
}
