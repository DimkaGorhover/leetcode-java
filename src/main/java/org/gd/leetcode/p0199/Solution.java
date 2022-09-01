package org.gd.leetcode.p0199;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-right-side-view/
 *
 * @author Horkhover Dmytro
 * @since 2019-01-03
 */
@LeetCode(difficulty = LeetCode.Level.MEDIUM)
class Solution {

    private List<Integer> list;

    private void traverse(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level == list.size()) {
            list.add(root.val);
        }
        traverse(root.right, level + 1);
        traverse(root.left, level + 1);
    }

    public List<Integer> rightSideView(TreeNode root) {
        list = new ArrayList<>();
        traverse(root, 0);
        return list;
    }
}
