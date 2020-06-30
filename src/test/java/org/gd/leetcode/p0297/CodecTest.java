package org.gd.leetcode.p0297;

import org.gd.leetcode.common.TreeNode;
import org.gd.leetcode.p0297.Codec.Node;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

/**
 * Test for {@link Codec}
 *
 * @author Horkhover D.
 * @since 2020-06-16
 */
@DisplayName("LeetCode #297")
class CodecTest {

    static Stream<Arguments> args() {
        return Stream.of(
            Arguments.of(TreeNode.of(1, 2, 3, 4, 5, 6, 7)),
            Arguments.of(TreeNode.of(1, 2, 3, 4, null, null, 7)),
            Arguments.of(TreeNode.of(1, 2, 3, 4, null, null, null))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("LeetCode #297: Creating Inner Node")
    void node(TreeNode treeNode) {

        Node.of(treeNode).forEach(node -> {
            String offset = "";
            if (node.parentId >= 0) {
                offset = " ".repeat(node.parentId * 2 + 2);
            }
            System.out.println(offset + node);
        });
        System.out.println();
    }

    @Test
    @DisplayName("LeetCode #297: Check TreeNode Size")
    void test_Size() {
        
        TreeNode treeNode = TreeNode.of(1, 2, 3, 4, 5, 6, 7);
        assertEquals(7, Codec.size(treeNode));

        treeNode = TreeNode.of(1, 2, 3, 4, null, null, 7);
        assertEquals(5, Codec.size(treeNode));
    }

    @Test
    @DisplayName("LeetCode #297: Serialize")
    void test_Serialize() {
        TreeNode treeNode = TreeNode.of(1, 2, 3, 4, 5, 6, 7);
        String serialize = new Codec().serialize(treeNode);
    }

    @Test
    @DisplayName("LeetCode #297: Deserialize")
    void test_Deserialize() {
        throw new UnsupportedOperationException(new String(new char[]{175, 92, 95, 40, 12_484, 41, 95, 47, 175}));
    }
}
