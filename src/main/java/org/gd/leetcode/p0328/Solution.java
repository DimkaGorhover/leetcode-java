package org.gd.leetcode.p0328;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/odd-even-linked-list/
 *
 * @author Horkhover Dmytro
 * @since 2020-08-24
 */
@LeetCode(
        name = "Odd Even Linked List",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = LeetCode.Tags.LINKED_LIST
)
class Solution {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode odd = new ListNode(-1);
        ListNode oddHead = odd;
        ListNode even = new ListNode(-1);
        ListNode evenHead = even;
        ListNode node = head;
        int i = 1;
        while (node != null) {
            ListNode next = node.next;
            node.next = null;
            if ((i++) % 2 == 0) {
                even = (even.next = node);
            } else {
                odd = (odd.next = node);
            }
            node = next;
        }

        odd.next = evenHead.next;
        return oddHead.next;
    }
}
