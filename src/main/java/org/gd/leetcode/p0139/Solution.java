package org.gd.leetcode.p0139;

import org.gd.leetcode.common.LeetCode;

import java.util.*;

/**
 * https://leetcode.com/problems/word-break/
 *
 * @author Horkhover D.
 * @see org.gd.leetcode.p0140.Solution
 * @since 2020-07-11
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Word Break",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.TODO,
        tags = LeetCode.Tags.DYNAMIC_PROGRAMMING
)
class Solution {

    private Set<String> dict;
    private boolean[] dp;
    private int maxLength;
    private int minLength;

    private void reset(String word, List<String> wordDict) {

        dp = new boolean[word.length() + 1];
        dp[0] = true;

        dict = new HashSet<>();
        maxLength = 0;
        minLength = Integer.MAX_VALUE;
        for (String dictWord : wordDict) {
            final int length = dictWord.length();
            maxLength = Math.max(maxLength, length);
            minLength = Math.min(minLength, length);
            dict.add(dictWord);
        }
    }

    public boolean wordBreak(String word, List<String> wordDict) {
        reset(word, wordDict);
        for (int i = minLength; i <= word.length(); i++) {
            for (int j = Math.max(0, i - maxLength); i - j >= minLength; j++) {
                String subWord = word.substring(j, i);
                if (dp[j] && dict.contains(subWord)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[word.length()];
    }
}
