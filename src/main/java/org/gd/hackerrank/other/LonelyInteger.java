package org.gd.hackerrank.other;

/**
 * https://www.hackerrank.com/challenges/lonely-integer/
 * 
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0136.Solution
 * @since 2020-06-19
 */
class LonelyInteger {

    private LonelyInteger() {
    }

    static int lonelyinteger(int[] a) {
        for (int i = 1; i < a.length; i++)
            a[0] ^= a[i];
        return a[0];
    }
}
