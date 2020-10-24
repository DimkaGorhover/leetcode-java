package org.gd.leetcode.p0012;

import org.gd.leetcode.common.LeetCode;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/integer-to-roman/
 *
 * @see org.gd.leetcode.p0013.Solution
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Integer to Roman",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.TODO,
        tags = {
                LeetCode.Tags.MATH,
                LeetCode.Tags.STRING
        }
)
class Solution {

    private static final List<Map<Character, Integer>> LIST = Arrays.asList(
            Map.ofEntries(
                    Map.entry('I', 1),
                    Map.entry('V', 5),
                    Map.entry('X', 10)),
            Map.ofEntries(
                    Map.entry('X', 10),
                    Map.entry('L', 50),
                    Map.entry('C', 100)),
            Map.ofEntries(
                    Map.entry('C', 100),
                    Map.entry('D', 500),
                    Map.entry('M', 1000))
    );

    private static final Map<Character, Integer> map = Map.ofEntries(
            Map.entry('I', 1),
            Map.entry('V', 5),
            Map.entry('X', 10),
            Map.entry('L', 50),
            Map.entry('C', 100),
            Map.entry('D', 500),
            Map.entry('M', 1000)
    );

    public String intToRoman(int num) {
        while (num > 0) {
            int next = num % 10;


            num /= 10;
        }

        throw new UnsupportedOperationException(new String(new char[]{ 175, 92, 95, 40, 12_484, 41, 95, 47, 175 }));
    }
}
