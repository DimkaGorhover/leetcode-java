package org.gd.leetcode.p0347;

import org.gd.leetcode.common.LeetCode;

/**
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0215.Solution
 * @see org.gd.leetcode.p0692.Solution
 * @see org.gd.leetcode.p0973.Solution
 * @since 2020-08-10
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Top K Frequent Elements",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.HASH_TABLE,
                LeetCode.Tags.HEAP
        }
)
interface Solution {

    int[] topKFrequent(int[] nums, int k);
}
