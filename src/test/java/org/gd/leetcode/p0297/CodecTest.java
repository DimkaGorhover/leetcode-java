package org.gd.leetcode.p0297;

import org.gd.leetcode.common.TreeNode;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Codec}
 *
 * @author Horkhover D.
 * @since 2020-06-16
 */
class CodecTest {

    @Test
    @DisplayName("Size")
    void test_Size() {
        TreeNode treeNode = TreeNode.of(1, 2, 3, 4, 5, 6, 7);
        assertEquals(7, Codec.size(treeNode));
    }

    @Test
    @DisplayName("Serialize")
    void test_Serialize() {
        TreeNode treeNode = TreeNode.of(1, 2, 3, 4, 5, 6, 7);
        String serialize = new Codec().serialize(treeNode);
    }

    @Test
    @DisplayName("Deserialize")
    void test_Deserialize() {
        throw new UnsupportedOperationException(new String(new char[]{175, 92, 95, 40, 12_484, 41, 95, 47, 175}));
    }
}
