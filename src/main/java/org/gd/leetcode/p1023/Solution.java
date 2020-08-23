package org.gd.leetcode.p1023;

import org.gd.leetcode.common.LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/camelcase-matching/
 *
 * @author Horkhover Dmytro
 * @since 2020-08-23
 */
@LeetCode(
        name = "Camelcase Matching",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.STRING,
                LeetCode.Tags.TRIE,
                LeetCode.Tags.TWO_POINTERS
        }
)
class Solution {

    private static boolean camelMatch(String word, String pattern) {

        if (word == null)
            return false;

        final int patternLength = pattern.length();
        final int wordLength = word.length();

        int patternIndex = 0;
        int wordIndex = 0;

        for (; patternIndex < patternLength && wordIndex < wordLength; wordIndex++) {
            char c = word.charAt(wordIndex);
            if (pattern.charAt(patternIndex) == c) {
                patternIndex++;
            } else if (Character.isUpperCase(c)) {
                return false;
            }
        }

        for (; wordIndex < wordLength; wordIndex++)
            if (Character.isUpperCase(word.charAt(wordIndex)))
                return false;

        return patternIndex == patternLength;
    }

    public List<Boolean> camelMatch(String[] words, String pattern) {

        if (words == null || words.length == 0)
            return Collections.emptyList();

        List<Boolean> result = new ArrayList<>(words.length);
        for (String word : words)
            result.add(camelMatch(word, pattern));

        return result;
    }
}
