package org.gd.leetcode.p1367;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.ListNode;
import org.gd.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/linked-list-in-binary-tree/
 *
 * @author Horkhover Dmytro
 * @since 2020-09-22
 */
@LeetCode(
        name = "Linked List in Binary Tree",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.LINKED_LIST,
                LeetCode.Tags.TREE,
                LeetCode.Tags.DYNAMIC_PROGRAMMING
        }
)
class Solution {

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;

        return dfs(head, root)
                || isSubPath(head, root.left)
                || isSubPath(head, root.right);
    }

    private boolean dfs(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;

        return head.val == root.val
                && (dfs(head.next, root.left) || dfs(head.next, root.right));
    }
}
