package org.gd.leetcode.p0470;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/implement-rand10-using-rand7
 *
 * <p>Given a function rand7 which generates a uniform random integer in the range 1 to 7, write a function rand10
 * which generates a uniform random integer in the range 1 to 10.</p>
 *
 * <p>Do NOT use system's Math.random().</p>
 *
 * <code><pre>
 * Example 1:
 *
 * Input: 1
 * Output: [7]
 * </pre></code>
 *
 * <code><pre>
 * Example 2:
 *
 * Input: 2
 * Output: [8,4]
 * </pre></code>
 *
 * <code><pre>
 * Example 3:
 *
 * Input: 3
 * Output: [8,1,10]
 * </pre></code>
 *
 * <p>Note:</p>
 *
 * <ol>
 * <li>rand7 is predefined.</li>
 * <li>Each testcase has one argument: n, the number of times that rand10 is called.</li>
 * </ol>
 *
 * <p>Follow up:</p>
 *
 * <ol>
 * <li>What is the expected value for the number of calls to rand7() function?</li>
 * <li>Could you minimize the number of calls to rand7()?</li>
 * </ol>
 */
@LeetCode(
        name = "Implement Rand10() Using Rand7()",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.RANDOM,
                LeetCode.Tags.REJECTION_SAMPLING
        })
class Solution extends SolBase {

    public int rand10() {
        int row, col, idx;
        do {
            row = rand7();
            col = rand7();
            idx = col + (row - 1) * 7;
        } while (idx > 40);
        return 1 + (idx - 1) % 10;
    }
}
