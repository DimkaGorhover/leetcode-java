package org.gd.leetcode.p0022;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Test for {@link Solution}
 */
class SolutionTest {
    
    @Test
    @DisplayName("LeetCode #22: Generate Parentheses")
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