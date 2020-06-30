package org.gd.leetcode.p0022;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.LeetCode.Level;
import org.gd.leetcode.common.LeetCode.Tags;

/**
 * https://leetcode.com/problems/generate-parentheses/
 * 
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 * 
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0020.Solution
 */
@LeetCode(difficulty = Level.MEDIUM, tags = { Tags.BACKTRACKING, Tags.STRING })
class Solution {

    private List<String> list;

    public List<String> generateParenthesis(int n) {
        if (n <= 0)
            return Collections.emptyList();

        if (n == 1)
            return Arrays.asList("()");

        list = new ArrayList<>();
        byte[] chars = new byte[n << 1];
        chars[0] = '(';

        generateParenthesis(n - 1, n, chars, 1);

        return list;
    }

    private void generateParenthesis(int openQuota, int closeQuota, byte[] chars, int charsIndex) {
        if (openQuota > 0 || closeQuota > 0) {

            if (openQuota > 0) {
                chars[charsIndex] = '(';
                generateParenthesis(openQuota - 1, closeQuota, chars, charsIndex + 1);
            }

            if (closeQuota > 0 && openQuota < closeQuota) {
                chars[charsIndex] = ')';
                generateParenthesis(openQuota, closeQuota - 1, chars, charsIndex + 1);
            }

        } else {
            list.add(new String(chars, 0, chars.length, StandardCharsets.ISO_8859_1));
        }
    }
}
