package org.gd.leetcode.p0068;

import org.gd.leetcode.common.LeetCode;

import java.util.List;

/**
 * https://leetcode.com/problems/text-justification/
 *
 * @author Horkhover D.
 * @since 2020-07-05.07.2020
 */
@LeetCode(
        name = "Text Justification",
        difficulty = LeetCode.Level.HARD,
        state = LeetCode.State.TODO,
        tags = LeetCode.Tags.STRING
)
class Solution {

    public List<String> fullJustify(String[] words, int maxWidth) {
        Lines lines = new Lines(maxWidth);
        for (String word : words) {
            lines.add(word);
        }
        return lines.toListStrings();
    }

}
