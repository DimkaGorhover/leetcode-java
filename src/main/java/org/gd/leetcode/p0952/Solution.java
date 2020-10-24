package org.gd.leetcode.p0952;

import org.gd.common.Repeat;
import org.gd.leetcode.common.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/largest-component-size-by-common-factor/
 */
@Repeat("stolen solution")
@LeetCode(
        name = "Largest Component Size by Common Factor",
        difficulty = LeetCode.Level.HARD,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.MATH,
                LeetCode.Tags.UNION_FIND
        }
)
class Solution {

    @SuppressWarnings("unused")
    private static final int[] FACTORS = {
            2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101,
            103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197,
            199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313
    };

    private int[] p;

    private static int findMaxValue(int[] arr) {
        int maxValueIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[maxValueIndex] < arr[i])
                maxValueIndex = i;
        }
        return arr[maxValueIndex];
    }

    private int get(int x) {
        return p[x] == x ? x : (p[x] = get(p[x]));
    }

    private void add(int x, int y) {
        p[get(x)] = p[get(y)];
    }

    public int largestComponentSize(int[] A) {

        final int maxValue = findMaxValue(A);
        Arrays.setAll(p = new int[maxValue + 1], i -> i);

        for (int number : A) {
            for (int divider = (int) Math.sqrt(number); divider >= 2; divider--) {
                if (number % divider == 0) {
                    add(number, divider);
                    add(number, number / divider);
                }
            }
        }

        Map<Integer, Integer> map = new HashMap<>(maxValue);
        int res = 0;
        for (int number : A) {
            int v = map.compute(get(number), (key, prev) -> 1 + (prev == null ? 0 : prev));
            res = Math.max(res, v);
        }

        return res;
    }
}
