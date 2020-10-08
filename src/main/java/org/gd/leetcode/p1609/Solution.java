package org.gd.leetcode.p1609;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/even-odd-tree/
 *
 * @author Horkhover Dmytro
 * @since 2020-10-08
 */
@SuppressWarnings("ConstantConditions")
@LeetCode(
        name = "Even Odd Tree",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = LeetCode.Tags.TREE
)
class Solution {

    public boolean isEvenOddTree(TreeNode root) {
        if (root == null)
            throw new NullPointerException();

        BstQueue q = new BstQueue();
        q.add(root);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            if (isEven(level)) {
                int prev = Integer.MIN_VALUE;
                for (int i = 0; i < size; i++) {
                    int val = q.poll().val;
                    if (isEven(val) || prev >= val)
                        return false;
                    prev = val;
                }
            } else {
                int prev = Integer.MAX_VALUE;
                for (int i = 0; i < size; i++) {
                    int val = q.poll().val;
                    if (isOdd(val) || prev <= val)
                        return false;
                    prev = val;
                }
            }
            level++;
        }

        return true;
    }

    private static boolean isEven(int data) { return data % 2 == 0; }

    private static boolean isOdd(int data) { return !isEven(data); }

    static class BstQueue {

        private final LinkedList<TreeNode> list = new LinkedList<>();

        boolean isEmpty() {
            return list.isEmpty();
        }

        int size() {
            return list.size();
        }

        TreeNode poll() {
            if (isEmpty())
                return null;
            TreeNode poll = list.poll();
            add(poll.left);
            add(poll.right);
            return poll;
        }

        void add(TreeNode node) {
            if (node != null)
                list.add(node);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder().append('[');
            Iterator<TreeNode> iterator = list.iterator();
            if (iterator.hasNext()) {
                sb.append(iterator.next().val);
                while (iterator.hasNext())
                    sb.append(", ").append(iterator.next().val);
            }
            return sb.append(']').toString();
        }
    }
}
