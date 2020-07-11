package org.gd.leetcode.p0140;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-break-ii/
 */
public class Solution {

    private List<String> result;
    private Set<String> dict;
    private boolean[] dp;
    private int maxLength;
    private int minLength;

    private void reset(String word, List<String> wordDict) {

        result = new ArrayList<>();

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

    public List<String> wordBreak(String word, List<String> wordDict) {

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
        return result;
    }
}
