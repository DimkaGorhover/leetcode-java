package org.gd.leetcode.p0515;

import org.gd.leetcode.common.TreeNode;

import java.util.*;

/**
 * @author Horkhover Dmytro
 * @since 2020-08-15
 */
@SuppressWarnings("ConstantConditions")
class BFSSolution implements Solution {

    public List<Integer> largestValues(TreeNode root) {
        if (root == null)
            return Collections.emptyList();

        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        while (!q.isEmpty()) {

            final int size = q.size();

            for (int i = 0; i < size; i++) {

                TreeNode node = q.poll();

                if (result.size() == level) {
                    result.add(node.val);
                } else {
                    result.set(level, Math.max(result.get(level), node.val));
                }

                if (node.left != null)
                    q.add(node.left);

                if (node.right != null)
                    q.add(node.right);
            }

            level++;
        }

        return result;
    }
}
