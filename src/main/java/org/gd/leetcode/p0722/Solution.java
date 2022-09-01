package org.gd.leetcode.p0722;

import org.gd.leetcode.common.LeetCode;

import java.util.List;

/**
 * https://leetcode.com/problems/remove-comments/
 *
 * @author Horkhover Dmytro
 * @since 2022-01-24
 */
@LeetCode(
        name = "Remove Comments",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.TODO,
        tags = {
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.STRING
        }
)
interface Solution {

    List<String> removeComments(String[] source);
}
