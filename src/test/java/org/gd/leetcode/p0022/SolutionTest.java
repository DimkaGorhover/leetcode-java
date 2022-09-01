package org.gd.leetcode.p0022;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.gd.leetcode.common.CollectionUtils.setOf;

/**
 * Test for {@link Solution}
 */
@DisplayName("LeetCode #22: Generate Parentheses")
class SolutionTest {

    @Test
    void test() {
        Solution solution = new Solution();
        assertThat(solution.generateParenthesis(3)).containsExactlyElementsOf(setOf(
                "((()))",
                "(()())",
                "(())()",
                "()(())",
                "()()()"
        ));
    }
}