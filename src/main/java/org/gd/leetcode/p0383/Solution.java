package org.gd.leetcode.p0383;

import org.gd.leetcode.common.LeetCode;

/**
 * LeetCode #383: Ransom Note
 *
 * https://leetcode.com/problems/ransom-note/
 *
 * @author Horkhover Dmytro
 * @since 2022-01-14
 */
@LeetCode(
        name = "Ransom Note",
        difficulty = LeetCode.Level.EASY
)
class Solution {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] table = new int['z' - 'a' + 1];
        for (int i = 0; i < magazine.length(); i++) {
            table[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (--table[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
