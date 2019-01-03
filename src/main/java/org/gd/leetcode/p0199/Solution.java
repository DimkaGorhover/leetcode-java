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

    private static List<Integer> rightSideView(List<Integer> list, TreeNode root, int level) {
        if (root == null)
            return list;
        if (level == list.size())
            list.add(root.val);
        rightSideView(list, root.right, level + 1);
        rightSideView(list, root.left, level + 1);
        return list;
    }

    public List<Integer> rightSideView(TreeNode root) {
        return rightSideView(new ArrayList<>(), root, 0);
    }
}
