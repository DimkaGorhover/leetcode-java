package org.gd.leetcode.p0148;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/sort-list/
 *
 * @author Dmytro Horkhover
 * @since 2020-10-13
 */
@LeetCode(
        name = "Sort List",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.SORT,
                LeetCode.Tags.LINKED_LIST
        }
)
interface Solution {

    ListNode sortList(ListNode head);
}
