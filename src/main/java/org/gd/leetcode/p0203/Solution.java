package org.gd.leetcode.p0203;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.ListNode;

/**
 * TODO: https://leetcode.com/problems/remove-linked-list-elements/submissions/
 *
 * @since 2019-08-23
 */
@LeetCode(
        difficulty = LeetCode.Level.EASY,
        tags = LeetCode.Tags.LINKED_LIST)
class Solution {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;
        while (head != null && head.val == val)
            head = head.next;
        ListNode _next, _head = head;
        while (_head != null && (_next = _head.next) != null) {
            if (_next.val == val) {
                _head.next = _next.next;
            }
            _head = _head.next;
        }
        return head;
    }
}
