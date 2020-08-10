package org.gd.leetcode.p0168;

/**
 * @author Horkhover Dmytro
 * @since 2020-08-10
 */
class LoopSolution implements Solution {

    private static final int RADIX = 'Z' - 'A' + 1;

    private static int length(int n) {
        int length = 0;
        for (; n > 0; length++)
            n = (n - 1) / RADIX;
        return length;
    }

    public String convertToTitle(int n) {
        if (n <= 0)
            throw new IndexOutOfBoundsException();
        if (n < 27)
            return "" + ((char) ('A' + n - 1));

        char[] chars = new char[length(n)];
        int index = chars.length - 1;

        while (n > 0) {
            int i = (n - 1) % RADIX;
            char c = (char) ('A' + i);
            chars[index--] = c;
            n = (n - 1) / RADIX;
        }
        return new String(chars);
    }
}
