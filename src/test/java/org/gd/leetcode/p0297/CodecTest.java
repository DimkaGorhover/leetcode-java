package org.gd.leetcode.p0297;

import org.gd.leetcode.common.TreeNode;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link Codec}
 *
 * @author Horkhover D.
 * @since 2020-06-16
 */
@Disabled
@DisplayName("LeetCode #297: serialize and deserialize binary tree")
class CodecTest {

    static Stream<Arguments> args() {

        return Stream.of(
                Arguments.of(TreeNode.of()),
                Arguments.of(TreeNode.of(1, 2, 3, 4, 5, 6, 7)),
                Arguments.of(TreeNode.of(1, 2, 3, 4, 5, 6)),
                Arguments.of(TreeNode.of(1, 2, 3, 4, 5)),
                Arguments.of(TreeNode.of(1, 2, 3, 4)),
                Arguments.of(TreeNode.of(1, 2, 3, null, 4, 5)),
                Arguments.of(TreeNode.of(1, 2, 3, 4, null, null, 7)),
                Arguments.of(TreeNode.of(1, 2, 3, 4, null, null, null))
        );
    }

    @Test
    @DisplayName("LeetCode #297: Check TreeNode Size")
    void test_Size() {

        TreeNode treeNode = TreeNode.of(1, 2, 3, 4, 5, 6, 7);
        assertEquals(7, Codec.size(treeNode));

        treeNode = TreeNode.of(1, 2, 3, 4, null, null, 7);
        assertEquals(5, Codec.size(treeNode));
    }

    @Timeout(2)
    @SuppressWarnings("deprecation")
    @ParameterizedTest
    @MethodSource("args")
    void test_Serialize() {
        TreeNode treeNode = TreeNode.of(1, 2, 3, 4, 5, 6, 7);
        String serialize = new Codec().serialize(treeNode.copy());
        assertEquals(treeNode, new Codec().deserialize(serialize));
    }
}
