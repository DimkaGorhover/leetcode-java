package org.gd.apptopia;

/**
 * @author Horkhover Dmytro
 * @since 2020-08-19
 */
public class NumberUtils {

    private NumberUtils() { throw new UnsupportedOperationException(); }

    public static int readInt(String str, int from, int length) {
        int intValue = 0;
        for (int i = from; i < from + length; i++) {
            char c = str.charAt(i);
            intValue = (intValue * 10) + (c - '0');
        }
        return intValue;
    }
}
