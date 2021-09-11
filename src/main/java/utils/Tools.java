package utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Tools {

    public static BigDecimal getBigDecimalFromString(String textToParse) {
        // currently handles any string form and parses it to 10000.00 always;
        final RoundingMode DEFAULT_ROUNDING = RoundingMode.HALF_EVEN;
        final String onlyDigits = textToParse.replaceAll("\\D+", "");
        final BigDecimal balance = new BigDecimal(onlyDigits).divide(BigDecimal.valueOf(100), DEFAULT_ROUNDING).setScale(2, DEFAULT_ROUNDING);
        return balance;
    }

//    public static boolean compareTwoAmounts(final BigDecimal expectedBigger, final BigDecimal expectedSmaller) {
//        // TODO
//    }//
//
//    public static boolean areMoneyAmountsEqual(final BigDecimal expected, final BigDecimal actual) {
//        // TODO
//    }
}
