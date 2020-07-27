package org.gd.leetcode.p0239;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/sliding-window-maximum/
 *
 * @author Gorkhover D.
 * @see org.gd.leetcode.p0155.MinStack
 * @see org.gd.leetcode.p0155.LinkedMinStack
 * @since 2018-11-02
 */
@SuppressWarnings({"JavadocReference"})
@LeetCode(
        name = "Sliding Window Maximum",
        difficulty = LeetCode.Level.HARD,
        state = LeetCode.State.FIXME,
        tags = {
                LeetCode.Tags.HEAP,
                LeetCode.Tags.SLIDING_WINDOW
        }
)
interface Solution {

    int[] maxSlidingWindow(int[] nums, int k);
}
