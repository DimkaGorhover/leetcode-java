package org.gd.leetcode.p0017;

import java.util.List;

/**
 * TODO: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 *
 * @author Gorkhover D.
 * @since 2018-10-24
 */
class Solution {

    private static final int[][] VALUES = {
            {},
            {},
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };

    public List<String> letterCombinations(String digits) {
        for (int i = 0; i < digits.length(); i++) {
            int[] value = VALUES[digits.charAt(i) - 48];
        }

    }

}
