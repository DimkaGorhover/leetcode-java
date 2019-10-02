package org.gd.hackerrank.other;

import org.gd.hackerrank.common.HackerRank;

import java.util.HashSet;
import java.util.Set;

/**
 * https://www.hackerrank.com/challenges/pairs/problem
 *
 * @since 2019-09-25
 */
@HackerRank(difficulty = HackerRank.Level.MEDIUM)
class Pairs {

    private Pairs() { throw new UnsupportedOperationException(); }

    static int pairs(int k, int[] arr) {
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int value : arr) {
            if ((k > value && set.contains(k - value)) || (k <= value && set.contains(value - k))) {
                count++;
            }
            set.add(value);
        }
        return count;
    }
}
