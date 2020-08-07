package org.gd.leetcode.p0426;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
 *
 * @author Horkhover Dmytro
 * @since 2020-08-07
 */
@LeetCode(
        name = "Convert Binary Search Tree to Sorted Doubly Linked List",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.PAID,
        tags = {
                LeetCode.Tags.LINKED_LIST,
                LeetCode.Tags.BINARY_SEARCH_TREE
        }
)
class Solution {

    private Node head;

    static Node connect(Node left, Node right) {
        left.next = right;
        right.prev = left;
        return right;
    }

    private void traverse(TreeNode root) {
        if (root == null)
            return;

        traverse(root.left);
        head = connect(head, new Node(root.val));
        traverse(root.right);
    }

    public Node toDoublyLinkedList(TreeNode root) {
        Node dummy = new Node(0);
        head = dummy;

        traverse(root);

        Node next = dummy.next;
        next.prev = null;
        return next;
    }

}
