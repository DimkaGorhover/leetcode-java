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
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.STRING
        }
)
class Solution {

    private static boolean allPass(String word, int pos, CharPredicate predicate) {
        for (int i = pos; i < word.length(); i++) {
            if (!predicate.test(word.charAt(i)))
                return false;
        }
        return true;
    }

    public boolean detectCapitalUse(String word) {
        if (word == null || word.length() <= 1)
            return true;

        if (CharPredicate.LOWER.test(word.charAt(0)))
            return allPass(word, 1, CharPredicate.LOWER);

        return allPass(word, 2, CharPredicate.UPPER.test(word.charAt(1)) ? CharPredicate.UPPER : CharPredicate.LOWER);
    }

    interface CharPredicate {

        CharPredicate LOWER = Character::isLowerCase;
        CharPredicate UPPER = Character::isUpperCase;

        boolean test(char c);
    }
}
