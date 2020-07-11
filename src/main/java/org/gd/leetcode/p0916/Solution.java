package org.gd.leetcode.p0916;

import org.gd.leetcode.common.LeetCode;

import java.util.List;

/**
 * https://leetcode.com/problems/word-subsets/
 *
 * @author Horkhover D.
 * @since 2020-07-10
 */
@LeetCode(
        name = "Word Subsets",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.FIXME,
        tags = LeetCode.Tags.STRING
)
interface Solution {

    List<String> wordSubsets(String[] A, String[] B);
}
