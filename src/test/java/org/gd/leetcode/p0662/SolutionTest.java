package org.gd.leetcode.p0662;

import org.gd.leetcode.common.TreeNode;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @since 2020-07-18
 */
class SolutionTest {

    private static Stream<Arguments> args() {

        return Stream
                .of(new TwoListsSolutionFactory(), new CustomSolutionFactory())
                .flatMap(sf -> Stream.of(

                        Arguments.of(sf, TreeNode.of(1, 1, 1, 1, 1, 1, 1, null, null, null, 1, null, null, null, null, 2, 2, 2, 2, 2, 2, 2, null, 2, null, null, 2, null, 2), 8),

                        Arguments.of(sf, TreeNode.of(1, 1, 1, 1, null, null, 1, 1, null, null, 1), 8),

                        Arguments.of(sf, TreeNode.of(1, 1, 1, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1,
                                null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null,
                                1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1,
                                null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null,
                                1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1,
                                null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, null, 1, 1, null, 1, null, 1, null,
                                1, null, 1, null), 2_147_483_645),

                        Arguments.of(sf, TreeNode.of(
                                0, 0, 0, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0,
                                null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null,
                                null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null,
                                0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0,
                                null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null,
                                null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null,
                                0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0,
                                null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null,
                                null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null,
                                0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0,
                                null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null,
                                null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null,
                                0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null), 2),

                        Arguments.of(sf, TreeNode.of(1, 3, 2, 5), 2),
                        Arguments.of(sf, TreeNode.of(1, 3, 2, 5, 3, null, 9), 4)
                ));
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("WidthOfBinaryTree")
    void test_WidthOfBinaryTree(SolutionFactory sf, TreeNode root, int expected) {
        Solution solution = sf.get();
        assertEquals(expected, solution.widthOfBinaryTree(root));
    }
}