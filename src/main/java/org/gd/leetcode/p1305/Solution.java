package org.gd.leetcode.p1305;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

import java.util.*;

/**
 * https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
 *
 * @author Horkhover Dmytro
 * @since 2020-08-07
 */
@LeetCode(
        name = "All Elements in Two Binary Search Trees",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.SORT,
                LeetCode.Tags.TREE,
                LeetCode.Tags.BINARY_SEARCH_TREE
        }
)
class Solution {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        TreeNodeItr itr1 = TreeNodeItrImpl.of(root1);
        TreeNodeItr itr2 = TreeNodeItrImpl.of(root2);

        List<Integer> result = new ArrayList<>();
        while (itr1.hasNext() || itr2.hasNext()) {
            int val1 = itr1.hasNext() ? itr1.peek() : Integer.MAX_VALUE;
            int val2 = itr2.hasNext() ? itr2.peek() : Integer.MAX_VALUE;
            if (val1 < val2) {
                result.add(val1);
                itr1.remove();
            } else {
                result.add(val2);
                itr2.remove();
            }
        }
        return result;
    }

    interface TreeNodeItr {

        boolean hasNext();

        Integer peek();

        void remove();
    }

    static class EmptyTreeNodeItr implements TreeNodeItr {

        static final EmptyTreeNodeItr INSTANCE = new EmptyTreeNodeItr();

        private EmptyTreeNodeItr() {}

        @Override
        public boolean hasNext() { return false; }

        @Override
        public Integer peek() { throw new NoSuchElementException(); }

        @Override
        public void remove() { throw new NoSuchElementException(); }
    }

    static class TreeNodeItrImpl implements TreeNodeItr {

        private final Deque<TreeNode> stack;

        private Integer next = null;

        private TreeNodeItrImpl(TreeNode root) {
            stack = new LinkedList<>();
            if (root != null)
                stack.addFirst(root);
        }

        static TreeNodeItr of(TreeNode root) {
            if (root == null)
                return EmptyTreeNodeItr.INSTANCE;

            return new TreeNodeItrImpl(root);
        }

        @Override
        public boolean hasNext() {
            if (next != null)
                return true;

            TreeNode node;
            while ((node = stack.pollFirst()) != null) {

                if (node.left != null) {

                    stack.addFirst(node);
                    stack.addFirst(node.left);
                    node.left = null;

                } else {

                    next = (node.val);
                    if (node.right != null)
                        stack.addFirst(node.right);

                    return true;
                }
            }

            return false;
        }

        @Override
        public Integer peek() {
            if (!hasNext())
                throw new NoSuchElementException();
            return next;
        }

        @Override
        public void remove() {
            this.next = null;
        }
    }
}
