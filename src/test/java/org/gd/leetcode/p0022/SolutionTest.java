package org.gd.leetcode.p0022;

import org.junit.jupiter.api.*;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 */
@DisplayName("LeetCode #22: Generate Parentheses")
class SolutionTest {

    @Test
    void test() {

        var expected = Set.of(
                "((()))",
                "(()())",
                "(())()",
                "()(())",
                "()()()"
        );

        var actual = Set.copyOf(new Solution().generateParenthesis(3));

        assertEquals(expected, actual);
    }
}