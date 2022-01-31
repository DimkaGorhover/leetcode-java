package org.gd.leetcode.p0215;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0347.Solution
 * @see org.gd.leetcode.p0692.Solution
 * @see org.gd.leetcode.p0973.Solution
 * @see org.gd.leetcode.p0703.KthLargest
 * @since 2020-08-10
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Kth Largest Element in an Array",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.DIVIDE_AND_CONQUER,
                LeetCode.Tags.HEAP,
                LeetCode.Tags.SORT,
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.QUICK_SELECT
        }
)
interface Solution {

    int findKthLargest(int[] nums, int k);
}
