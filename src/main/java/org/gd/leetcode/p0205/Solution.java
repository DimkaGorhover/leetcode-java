package org.gd.leetcode.p0205;

import org.gd.leetcode.common.LeetCode;

/**
 * <a href="https://leetcode.com/problems/isomorphic-strings/">LeetCode #205: Isomorphic Strings</a>
 *
 * @author Horkhover Dmytro
 * @since 2022-09-28
 */
@LeetCode(
        name = "Isomorphic Strings",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.STRING,
                LeetCode.Tags.HASH_TABLE
        }
)
class Solution {

    public boolean isIsomorphic(String s, String t) {

        Character[] forward = new Character[1 << 8];
        Character[] back = new Character[1 << 8];

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (forward[c1] == null && back[c2] == null) {
                forward[c1] = c2;
                back[c2] = c1;
            }
            if (forward[c1] == null || forward[c1] != c2) {
                return false;
            }
        }
        return true;
    }

    /*public boolean isIsomorphic(String s, String t) {
        int[] arr = new int[OFFSET << 1];
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (arr[c1] == 0) {
                arr[c1] = OFFSET + c1 - c2;
            } else {
                if (arr[c1] != OFFSET + c1 - c2) {
                    return false;
                }
            }
        }
        return true;
    }*/
}
