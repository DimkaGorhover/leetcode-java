package org.gd.hackerrank.other;

import java.math.BigInteger;

/**
 * https://www.hackerrank.com/challenges/a-very-big-sum
 *
 * @author Horkhover Dmytro
 * @since 2018-11-18
 */
class VeryBigSum {

    static long aVeryBigSum(long[] arr) {
        BigInteger sum = BigInteger.ZERO;
        for (int i = 0; i < arr.length; i++) {
            sum = sum.add(BigInteger.valueOf(arr[i]));
        }
        return sum.longValue();
    }
}
