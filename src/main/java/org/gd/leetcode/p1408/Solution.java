package org.gd.leetcode.p1408;

import org.gd.leetcode.common.LeetCode;

import java.util.*;

/**
 * https://leetcode.com/problems/string-matching-in-an-array/
 *
 * @author Horkhover Dmytro
 * @since 2020-09-27
 */
@LeetCode(
        name = "String Matching in an Array",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = LeetCode.Tags.STRING
)
class Solution {

    public List<String> stringMatching(String[] words) {

        if (words == null || words.length <= 1)
            return Collections.emptyList();

        Arrays.sort(words, Comparator.comparingInt(String::length));

        List<String> strings = new ArrayList<>();
        for (int i = 0; i < words.length - 1; i++) {
            String substring = words[i];
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].contains(substring)) {
                    strings.add(substring);
                    break;
                }
            }
        }

        return strings;
    }
}
