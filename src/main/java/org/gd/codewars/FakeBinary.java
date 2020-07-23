package org.gd.codewars;

/**
 * https://www.codewars.com/kata/57eae65a4321032ce000002d/
 *
 * @author Horkhover Dmytro
 * @since 2020-07-23
 */
class FakeBinary {

    private FakeBinary() { throw new UnsupportedOperationException(); }

    public static String fakeBin(String numberString) {
        char[] chars = new char[numberString.length()];
        for (int i = 0; i < chars.length; i++) {
            char c = numberString.charAt(i);
            if (c >= '5')
                chars[i] = '1';
            else
                chars[i] = '0';
        }
        return new String(chars);
    }
}
