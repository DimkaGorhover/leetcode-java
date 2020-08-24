package org.gd.leetcode.p0234;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.Objects;

/**
 * https://leetcode.com/problems/palindrome-linked-list/
 *
 * <pre>
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
 * </pre>
 *
 * @see org.gd.leetcode.p0009.Solution
 * @see org.gd.leetcode.p0025.Solution
 * @see org.gd.leetcode.p0096.Solution
 * @see org.gd.leetcode.p0206.Solution
 * @see org.gd.hackerrank.other.ReverseLinkedList
 * @since 2019-09-11
 * @since 2020-08-24
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Palindrome Linked List",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.LINKED_LIST,
                LeetCode.Tags.TWO_POINTERS
        })
interface Solution {

    boolean isPalindrome(ListNode head);
}
