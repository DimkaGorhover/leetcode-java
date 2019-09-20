package org.gd.hackerrank.other;

import org.gd.hackerrank.common.HackerRank;

/**
 * https://www.hackerrank.com/challenges/a-very-big-sum
 *
 * @author Horkhover Dmytro
 * @since 2018-11-18
 */
@HackerRank(difficulty = HackerRank.Level.EASY)
class VeryBigSum {

    static long aVeryBigSum(long[] arr) {
        long sum = 0;
        for (long l : arr)
            sum += l;
        return sum;
    }
}
