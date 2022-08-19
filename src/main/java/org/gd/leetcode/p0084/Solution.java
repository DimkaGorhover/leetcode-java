package org.gd.leetcode.p0084;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 *
 * @see org.gd.leetcode.p0053.Solution
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Largest Rectangle in Histogram",
        difficulty = LeetCode.Level.HARD,
        state = LeetCode.State.TODO,
        tags = {
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.STACK
        }
)
class Solution {

    public int largestRectangleArea(int[] heights) {

        if (heights == null || heights.length == 0)
            return 0;

        if (heights.length == 1)
            return heights[0];

        int max = 0;
        for (int i = 0; i < heights.length; i++) {

            max = Math.max(max, heights[i]);
            int lowestHeight = heights[i];

            for (int j = i + 1; j < heights.length; j++) {

                int width = j - i + 1;
                lowestHeight = Math.min(lowestHeight, heights[j]);
                max = Math.max(max, width * lowestHeight);

            }
        }
        return max;
    }
}
