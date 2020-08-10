package org.gd.leetcode.p0168;

/**
 * @author Horkhover Dmytro
 * @since 2020-08-10
 */
class RecursiveSolution implements Solution {

    private static final int RADIX = 'Z' - 'A' + 1;

    public String convertToTitle(int n) {
        if (n <= 0)
            throw new IndexOutOfBoundsException();

        if (n < 27)
            return "" + ((char) ('A' + n - 1));

        int i = (n - 1) % RADIX;
        char c = (char) ('A' + i);

        return convertToTitle((n - 1) / RADIX) + c;
    }
}
