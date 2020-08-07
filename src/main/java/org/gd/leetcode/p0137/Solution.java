package org.gd.leetcode.p0137;

import org.gd.common.Repeat;
import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/single-number-ii/
 *
 * https://www.geeksforgeeks.org/find-the-element-that-appears-once/
 *
 * https://stackoverflow.com/a/44100914
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0136.Solution
 * @since 2020-08-04
 */
@Repeat("find the element that appears once")
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Single Number II",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.BIT_MANIPULATION
        }
)
class Solution {

    public int singleNumber(int[] nums) {

        int ones = 0;
        int twos = 0;
        int commonBitMask;

        for (int num : nums) {
            twos = twos | (ones & num);
            ones = ones ^ num;
            commonBitMask = ~(ones & twos);
            ones &= commonBitMask;
            twos &= commonBitMask;
        }

        return ones;
    }
}
