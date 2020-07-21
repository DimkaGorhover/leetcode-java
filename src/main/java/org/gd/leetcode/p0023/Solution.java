package org.gd.leetcode.p0023;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 *
 * @see org.gd.leetcode.p0021.Solution
 * @since 2019-09-10
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Merge K Sorted Lists",
        state = LeetCode.State.DONE,
        difficulty = LeetCode.Level.HARD,
        tags = {
                LeetCode.Tags.LINKED_LIST,
                LeetCode.Tags.DIVIDE_AND_CONQUER,
                LeetCode.Tags.HEAP
        })
interface Solution {

    ListNode mergeKLists(ListNode[] lists);
}
