package org.gd.leetcode.p0011;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.Repeat;

/**
 * <a href="https://leetcode.com/problems/container-with-most-water/">LeetCode #11: Container With Most Water</a>
 *
 * @see org.gd.leetcode.p0042.Solution
 */
@Repeat
@LeetCode(
        name = "Container With Most Water",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.TWO_POINTERS
        })
@SuppressWarnings("JavadocReference")
class Solution {

    public int maxArea(int[] heights) {
        if (heights == null || heights.length < 2) {
            return 0;
        }

        if (heights.length == 2) {
            return Math.max(0, Math.min(heights[0], heights[1]));
        }

        int leftIndex = 0;
        int rightIndex = heights.length - 1;
        int max = 0;
        while (leftIndex < rightIndex) {
            int height = Math.min(heights[leftIndex], heights[rightIndex]);
            int width = rightIndex - leftIndex;
            max = Math.max(max, width * height);
            while (heights[leftIndex] <= height && leftIndex < rightIndex) {
                leftIndex++;
            }
            while (heights[rightIndex] <= height && leftIndex < rightIndex) {
                rightIndex--;
            }
        }
        return max;
    }
}
