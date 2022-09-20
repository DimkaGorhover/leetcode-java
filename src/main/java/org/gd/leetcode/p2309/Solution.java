package org.gd.leetcode.p2309;

import org.gd.leetcode.common.LeetCode;

/**
 * <a href="https://leetcode.com/problems/greatest-english-letter-in-upper-and-lower-case/">LeetCode #2309: Greatest English Letter in Upper and Lower Case</a>
 *
 * @author Horkhover Dmytro
 * @since 2022-09-20
 */
@LeetCode(
        name = "Greatest English Letter in Upper and Lower Case",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.HASH_TABLE,
                LeetCode.Tags.STRING,
                LeetCode.Tags.ENUMERATION
        }
)
class Solution {

    public String greatestLetter(String s) {
        if (s == null || s.length() <= 1) {
            return "";
        }
        int[] table = new int[26];
        int maxIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = c - 65;
            if (index > 31) {
                index -= 32;
                table[index] |= 1;
            } else {
                table[index] |= 2;
            }
            if (table[index] == 3 && index > maxIndex) {
                maxIndex = index;
            }
        }
        return maxIndex >= 0 ? String.valueOf((char) (maxIndex + 65)) : "";
    }
}
