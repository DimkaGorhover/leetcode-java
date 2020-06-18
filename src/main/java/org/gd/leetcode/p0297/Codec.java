package org.gd.leetcode.p0297;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

import java.nio.IntBuffer;

/**
 * TODO: https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 *
 * @since 2019-09-12
 */
@LeetCode(difficulty = LeetCode.Level.HARD, tags = {LeetCode.Tags.TREE, LeetCode.Tags.DESIGN})
class Codec {

    private static final byte NULL_FIELD = 0;
    private static final byte FIELD = 1;

    static int size(TreeNode root) {
        return root == null ? 0 : 1 + size(root.left) + size(root.right);
    }

    /** Encodes a tree to a single string. */
    public String serialize(TreeNode root) {

        IntBuffer.allocate(size(root));

        throw new UnsupportedOperationException(new String(new char[]{175, 92, 95, 40, 12_484, 41, 95, 47, 175}));
    }

    /** Decodes your encoded data to tree. */
    public TreeNode deserialize(String data) {
        throw new UnsupportedOperationException(new String(new char[]{175, 92, 95, 40, 12_484, 41, 95, 47, 175}));
    }
}
