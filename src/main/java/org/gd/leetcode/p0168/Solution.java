package org.gd.leetcode.p0168;

import org.gd.leetcode.common.LeetCode;

// @formatter:off
/**
 * https://leetcode.com/problems/excel-sheet-column-title/
 *
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 *
 * For example:
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 *
 * Example 1: 1 --> "A"
 *
 * Example 2: 28 --> "AB"

 * Example 3: 701 --> "ZY"
 *
 * @see org.gd.leetcode.p0171.Solution
 * @since 2019-10-03
 */
// @formatter:on
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Excel Sheet Column Title",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = LeetCode.Tags.MATH
)
interface Solution {

    String convertToTitle(int n);
}
