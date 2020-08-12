package org.gd.leetcode.p1253;

import org.gd.leetcode.common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/reconstruct-a-2-row-binary-matrix/
 *
 * @author Horkhover Dmytro
 * @since 2020-08-12
 */
@SuppressWarnings("SpellCheckingInspection")
@LeetCode(
        name = "Reconstruct a 2-Row Binary Matrix",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.MATH,
                LeetCode.Tags.GREEDY
        }
)
class Solution {

    private static int sum(int[] arr) {
        int sum = 0;
        for (int value : arr) {
            if (value < 0 || value > 2)
                return -1;
            sum += value;
        }
        return sum;
    }

    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {

        if (sum(colsum) != (upper + lower))
            return Collections.emptyList();

        final int length = colsum.length;
        final ArrayList<Integer> up = new ArrayList<>(length);
        final ArrayList<Integer> lo = new ArrayList<>(length);

        int diff = upper - lower, sum = 0;
        for (int i : colsum) {
            sum += i;
            if (i % 2 == 0) {
                up.add(i / 2);
                lo.add(i / 2);
            } else {
                if (diff >= 0) {
                    up.add(1);
                    lo.add(0);
                    diff--;
                } else {
                    up.add(0);
                    lo.add(1);
                    diff++;
                }
            }
        }
        if (diff != 0 || upper + lower != sum)
            return Collections.emptyList();

        return Arrays.asList(up, lo);
    }
}
