package org.gd.leetcode.p0167;

import org.gd.leetcode.common.LeetCode;

/**
 * @author Horkhover Dmytro
 * @since 2020-08-07
 */
@LeetCode(
        name = "Two Sum II - Input array is sorted",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.TWO_POINTERS,
                LeetCode.Tags.BINARY_SEARCH
        }
)
interface Solution {

    int[] twoSum(int[] numbers, int target);
}
