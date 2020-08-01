package org.gd.leetcode.p0520;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/detect-capital/
 *
 * <p>
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 * </p>
 *
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 *
 * <ol>
 *     <li>All letters in this word are capitals, like "USA".</li>
 *     <li>All letters in this word are not capitals, like "leetcode".</li>
 *     <li>Only the first letter in this word is capital, like "Google".</li>
 * </ol>
 *
 * Otherwise, we define that this word doesn't use capitals in a right way.
 *
 * @author Horkhover Dmytro
 * @since 2020-08-01
 */
@LeetCode(
        name = "Detect Capital",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.FIXME,
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
