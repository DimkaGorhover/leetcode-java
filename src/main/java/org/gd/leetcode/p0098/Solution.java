package org.gd.leetcode.p0098;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 *
 * @author Horkhover Dmytro
 * @since 2018-11-15
 */
@LeetCode(
        name = "Validate Binary Search Tree",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.TREE,
                LeetCode.Tags.DEPTH_FIRST_SEARCH
        }
)
interface Solution {

    private static boolean isValidBST(TreeNode root, long max, long min) {
        if (root == null)
            return true;

        if (root.val >= max || root.val <= min)
            return false;

        return isValidBST(root.left, root.val, min)
                && isValidBST(root.right, max, root.val);
    }

    boolean isValidBST(TreeNode root);



}
