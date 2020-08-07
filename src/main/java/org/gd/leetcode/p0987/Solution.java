package org.gd.leetcode.p0987;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

import java.util.*;

/**
 * https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
 *
 * @author Horkhover Dmytro
 * @since 2020-08-07
 */
@SuppressWarnings({"rawtypes", "unchecked"})
@LeetCode(
        name = "Vertical Order Traversal of a Binary Tree",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.HASH_TABLE,
                LeetCode.Tags.TREE
        }
)
class Solution {

    private int left = 0;
    private int right = 0;

    private void initBounds(final TreeNode root, final int pos) {
        if (root == null)
            return;
        left = Math.min(left, pos);
        right = Math.max(right, pos);
        initBounds(root.left, pos - 1);
        initBounds(root.right, pos + 1);
    }

    @SuppressWarnings({"UnnecessaryLocalVariable"})
    private static void add(List list, Entry value) {
        final List<Entry> entries = list;
        final int size = entries.size();
        if (size == 0 || entries.get(size - 1).compareTo(value) < 1) {
            entries.add(value);
        } else {
            int pos = Collections.binarySearch(entries, value);
            if (pos < 0)
                pos = -(pos + 1);
            entries.add(pos, value);
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        initBounds(root, 0);

        final int width = 1 + right - left;

        List<List<Integer>> result = new ArrayList<>(width);
        for (int i = 0; i < width; i++)
            result.add(new ArrayList<>());

        Queue<Entry> q = new LinkedList<>();
        q.add(Entry.root(root));
        Entry entry;
        while ((entry = q.poll()) != null) {

            add(result.get(entry.pos - left), entry);

            Entry left = entry.left();
            if (left != null)
                q.add(left);

            Entry right = entry.right();
            if (right != null)
                q.add(right);
        }

        for (List line : result)
            for (int i = 0; i < line.size(); i++)
                line.set(i, ((Entry) line.get(i)).node.val);

        return result;
    }

    static class Entry implements Comparable<Entry> {

        final TreeNode node;
        final int pos;
        final int level;

        private Entry(TreeNode node, int pos, int level) {
            this.node = node;
            this.pos = pos;
            this.level = level;
        }

        static Entry root(TreeNode node) {
            return new Entry(node, 0, 0);
        }

        Entry left() {
            return node.left == null ? null : new Entry(node.left, pos - 1, level + 1);
        }

        Entry right() {
            return node.right == null ? null : new Entry(node.right, pos + 1, level + 1);
        }

        @Override
        public int compareTo(Entry o) {
            int compare = Integer.compare(level, o.level);
            if (compare != 0)
                return compare;
            return Integer.compare(node.val, o.node.val);
        }
    }
}
