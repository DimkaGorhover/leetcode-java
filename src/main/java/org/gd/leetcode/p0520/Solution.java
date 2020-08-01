package org.gd.leetcode.p0520;

import org.gd.leetcode.common.LeetCode;

/**
 * @author Horkhover Dmytro
 * @since 2020-08-01
 */
@LeetCode(
        difficulty = LeetCode.Level.EASY,
        tags = {
                LeetCode.Tags.STRING
        }
)
class Solution {

    public boolean detectCapitalUse(String word) {
        if (word == null)
            return false;

        int length = word.length();
        switch (length) {
            case 0: return false;
            case 1:
            case 3:
            case 2: return Character.isUpperCase(word.charAt(0));
        }

        if (Character.isLowerCase(word.charAt(0)))
            return false;

        for (int i = 1; i < length; i++) {
            if (Character.isUpperCase(word.charAt(i)))
                return false;
        }

        return true;
    }
}
