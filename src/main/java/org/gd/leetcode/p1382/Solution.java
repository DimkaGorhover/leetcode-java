package org.gd.leetcode.p1382;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

import java.util.ArrayList;

/**
 * Task: https://leetcode.com/problems/balance-a-binary-search-tree/
 *
 * Articles:
 * <ul>
 *     <li>https://www.geeksforgeeks.org/convert-normal-bst-balanced-bst/</li>
 *     <li>https://www.geeksforgeeks.org/sorted-array-to-balanced-bst/</li>
 * </ul>
 *
 * @author Horkhover Dmytro
 * @since 2020-08-12
 */
@LeetCode(
        name = "Balance a Binary Search Tree",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.BINARY_SEARCH_TREE
        }
)
class Solution {

    private ArrayList<Integer> list;

    private void toList(TreeNode root) {
        if (root == null)
            return;
        toList(root.left);
        list.add(root.val);
        toList(root.right);
    }

    private TreeNode fill(int from, int to) {
        if (from > to)
            return null;

        int mid = (from + to) >>> 1;

        TreeNode node = new TreeNode(list.get(mid));

        node.left = fill(from, mid - 1);
        node.right = fill(mid + 1, to);

        return node;
    }

    public TreeNode balanceBST(TreeNode root) {
        list = new ArrayList<>();
        toList(root);
        return fill(0, list.size() - 1);
    }
}
