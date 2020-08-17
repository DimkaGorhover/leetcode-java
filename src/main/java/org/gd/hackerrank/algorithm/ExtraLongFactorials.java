package org.gd.hackerrank.algorithm;

import org.gd.hackerrank.common.HackerRank;

import java.math.BigInteger;

/**
 * https://www.hackerrank.com/challenges/extra-long-factorials/
 *
 * @author Horkhover Dmytro
 * @since 2020-08-17
 */
@HackerRank(difficulty = HackerRank.Level.MEDIUM)
class ExtraLongFactorials {

    private ExtraLongFactorials() { throw new UnsupportedOperationException(); }

    private static long fact(int n) {
        long f = 1;
        for (int i = 2; i <= n; i++)
            f = f * i;
        return f;
    }

    private static BigInteger biFactorial(int n) {
        BigInteger f = BigInteger.valueOf(fact(20));
        for (int i = 21; i <= n; i++) {
            f = BigInteger.valueOf(i).multiply(f);
        }
        return f;
    }

    static void extraLongFactorials(int n) {
        if (n < 0) {
            System.out.println(1);
            return;
        }
        if (n > 20) {
            System.out.println(biFactorial(n).toString(10));
            return;
        }

        System.out.println(fact(n));
    }
}
