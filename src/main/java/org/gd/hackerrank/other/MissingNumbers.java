package org.gd.hackerrank.other;

import org.gd.hackerrank.common.HackerRank;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * https://www.hackerrank.com/challenges/missing-numbers/
 *
 * @since 2019-09-23
 */
@HackerRank(difficulty = HackerRank.Level.EASY)
class MissingNumbers {

    private static final java.util.function.BiFunction<Integer, Integer, Integer>
            INC = (key, count) -> (count == null ? 0 : count) + 1,
            DEC = (key, count) -> (count == null ? 0 : count) - 1;

    private MissingNumbers() { throw new UnsupportedOperationException(); }

    static int[] missingNumbers(int[] arr, int[] expected) {

        Map<Integer, Integer> map = new HashMap<>(arr.length);
        for (int i : arr)
            map.compute(i, INC);

        Set<Integer> set = new TreeSet<>();
        for (int value : expected)
            if (map.compute(value, DEC) < 0)
                set.add(value);

        int[] lostInts = new int[set.size()];
        int i = 0;
        for (Integer v : set)
            lostInts[i++] = v;

        return lostInts;
    }
}
