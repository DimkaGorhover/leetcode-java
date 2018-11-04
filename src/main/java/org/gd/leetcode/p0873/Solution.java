package org.gd.leetcode.p0873;

import java.math.BigInteger;

/**
 * TODO: https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/
 *
 * @author Gorkhover D.
 * @since 2018-11-04
 */
class Solution {

    static BigInteger fib(int n) {
        if (n < 2)
            return BigInteger.ONE;

        BigInteger a1 = BigInteger.ZERO, a2 = BigInteger.ONE, f = a2;
        for (int i = 2; i <= n; i++) {
            f = a1.add(a2);
            a1 = a2;
            a2 = f;
        }
        return f;
    }

    public static void main(String[] args) {
        System.out.println(
                fib(100)
        );
    }

    public int lenLongestFibSubseq(int[] A) {
        if (A == null || A.length == 0)
            return 0;
        throw new UnsupportedOperationException();
    }
}
