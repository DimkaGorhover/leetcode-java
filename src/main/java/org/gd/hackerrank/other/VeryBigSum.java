package org.gd.hackerrank.other;

import static java.util.Arrays.spliterator;
import static java.util.stream.StreamSupport.longStream;

import org.gd.hackerrank.common.HackerRank;

/**
 * https://www.hackerrank.com/challenges/a-very-big-sum
 *
 * @author Horkhover Dmytro
 * @since 2018-11-18
 */
@HackerRank(difficulty = HackerRank.Level.EASY)
class VeryBigSum {

    private VeryBigSum() {
        throw new UnsupportedOperationException();
    }

    static long streamSolution(final long[] arr) {
        return longStream(spliterator(arr), arr.length > Short.MAX_VALUE).sum();
    }

    static long forLoopSolution(final long[] arr) {
        long sum = 0;
        for (final long l : arr)
            sum += l;
        return sum;
    }

    static long aVeryBigSum(final long[] arr) {
        return forLoopSolution(arr);
    }
}
