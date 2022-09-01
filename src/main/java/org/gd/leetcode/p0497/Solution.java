package org.gd.leetcode.p0497;

import org.gd.leetcode.common.Repeat;
import org.gd.leetcode.common.LeetCode;

import java.util.Random;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/random-point-in-non-overlapping-rectangles/
 *
 * @since 2020-08-22
 */
@Repeat("stolen solution")
@LeetCode(
        name = "Random Point in Non-overlapping Rectangles",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.BINARY_SEARCH,
                LeetCode.Tags.RANDOM
        }
)
class Solution {

    private final TreeMap<Integer, Integer> map = new TreeMap<>();
    private final int[][] rectangles;
    private final Random rnd = new Random();
    private final int sum;

    public Solution(int[][] rectangles) {
        this.rectangles = rectangles;

        int sum = 0;
        for (int i = 0; i < rectangles.length; i++) {
            int[] rect = rectangles[i];
            sum += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
            map.put(sum, i);
        }
        this.sum = sum;
    }

    public int[] pick() {
        int rectangle = map.ceilingKey(rnd.nextInt(sum) + 1);
        return pickInRect(rectangles[map.get(rectangle)]);
    }

    private int[] pickInRect(int[] rectangle) {
        int left = rectangle[0];
        int right = rectangle[2];
        int bottom = rectangle[1];
        int top = rectangle[3];

        return new int[]{
                left + rnd.nextInt(right - left + 1),
                bottom + rnd.nextInt(top - bottom + 1)};
    }
}
