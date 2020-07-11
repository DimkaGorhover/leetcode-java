package org.gd.leetcode.p0139;

import org.gd.leetcode.common.LeetCode;

import java.util.*;

/**
 * https://leetcode.com/problems/word-break/
 *
 * @author Horkhover D.
 * @since 2020-07-11
 */
@LeetCode(
        name = "Word Break",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.TODO,
        tags = LeetCode.Tags.DYNAMIC_PROGRAMMING
)
class Solution {

    private Map<Integer, Set<String>> groupByLength;
    private int[] lengths;
    private int maxLength;
    private int minLength;

    private static List<String> squash(List<String> wordDict) {
        if (wordDict == null || wordDict.isEmpty())
            return Collections.emptyList();

        // TODO: squash

        return wordDict;
    }

    private void resetDict(List<String> wordDict) {

        wordDict = squash(wordDict);

        maxLength = 0;
        minLength = Integer.MAX_VALUE;
        Set<Integer> lengths = new TreeSet<>(Comparator.comparingInt(value -> -value));
        groupByLength = new HashMap<>();

        for (String word : wordDict) {
            final int length = word.length();
            lengths.add(length);
            maxLength = Math.max(maxLength, length);
            minLength = Math.min(minLength, length);
            groupByLength.compute(length, (ignore, set) -> {
                if (set == null)
                    return Collections.singleton(word);
                if (set.size() == 1) {
                    set = new HashSet<>(set);
                }
                set.add(word);
                return set;
            });
            this.lengths = new int[lengths.size()];
            int i = 0;
            for (int value : lengths) {
                this.lengths[i++] = value;
            }
        }
    }

    private boolean wordBreak0(String word) {
        LinkedList<String> q = new LinkedList<>();
        q.add(word);
        while ((word = q.pollFirst()) != null) {
            final int wordLength = word.length();
            if (wordLength == 0) return true;
            if (wordLength < minLength) continue;

            for (int length : lengths) {
                if (length > wordLength) break;

                String leftSubstring = word.substring(0, length);
                if (groupByLength.get(length).contains(leftSubstring)) {

                    if (wordLength == length)
                        return true;

                    String rightSubstring = word.substring(length);
                    q.offerFirst(rightSubstring);
                }
            }
        }
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        resetDict(wordDict);
        return wordBreak0(s);
    }
}
