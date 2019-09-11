package org.gd.leetcode.p0234;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.Objects;

/**
 * TODO: https://leetcode.com/problems/palindrome-linked-list/
 *
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1:
 * Input: 1->2
 * Output: false
 *
 * Example 2:
 * Input: 1->2->2->1
 * Output: true
 *
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 *
 * @see org.gd.leetcode.p0009.Solution
 * @since 2019-09-11
 */
@SuppressWarnings("JavadocReference")
@LeetCode(difficulty = LeetCode.Level.EASY, tags = {LeetCode.Tags.LINKED_LIST, LeetCode.Tags.TWO_POINTERS})
class Solution {

    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null)
            return true;

        final ArrayList<Integer> integers = new ArrayList<>();
        for (; head != null; head = head.next)
            integers.add(head.val);

        final int n = integers.size();
        for (int i = 0; i < n / 2 + 1; i++)
            if (!Objects.equals(integers.get(i), integers.get(n - i - 1)))
                return false;

        return true;
    }
}
