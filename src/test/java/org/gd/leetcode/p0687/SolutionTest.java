package org.gd.leetcode.p0687;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.gd.leetcode.common.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

    static Stream<Arguments> args() {
        return Stream.of(

                Arguments.of(2, TreeNode.of(1, 4, 5, 4, 4, 5)),

                Arguments.of(2, TreeNode.of(
                                    5,
                                5, null,
                            5, null,
                        1, null,
                    3, null
                )),

                Arguments.of(2, TreeNode.of(
                         5,
                     4,      5,
                    1, 1,   5, null
                )),

                Arguments.of(2, TreeNode.of(
                         1,
                     4,      5,
                    4, 4,   5, null
                )),

                Arguments.of(2, TreeNode.of(
                            1,
                        4,      5,
                    4,  4,      5, null
                ))

        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("LeetCode #687: Longest Univalue Path")
    void test(int expected, TreeNode root) {
        int actual = new Solution().longestUnivaluePath(root);
        assertEquals(expected, actual);
    }
}
