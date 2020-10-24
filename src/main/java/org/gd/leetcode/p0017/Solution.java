package org.gd.leetcode.p0017;

import org.gd.leetcode.common.LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 *
 * @author Gorkhover D.
 * @since 2018-10-24
 */
@LeetCode(
        name = "Letter Combinations of a Phone Number",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.STRING,
                LeetCode.Tags.BACKTRACKING
        }
)
class Solution {

    private static final byte[][] VALUES = {
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


    private static byte[] chars(String digits, int pos) { return VALUES[digits.charAt(pos) - 48]; }

    private static List<String> recursive(List<String> list, String digits, byte[] chars, int pos) {
        int last = digits.length() - 1;
        if (pos > last)
            return list;
        if (pos == last) {
            for (byte c : chars(digits, pos)) {
                chars[last] = c;
                list.add(new String(chars));
            }
            return list;
        }
        final int nextPos = pos + 1;
        for (byte c : chars(digits, pos)) {
            chars[pos] = c;
            recursive(list, digits, chars, nextPos);
        }
        return list;
    }

    private static List<String> single(String digits) {
        final byte[] chars = chars(digits, 0);
        final List<String> strings = new ArrayList<>(chars.length);
        for (byte c : chars)
            strings.add("" + ((char) c));
        return strings;
    }

    public List<String> letterCombinations(String digits) {
        final int length;
        if (digits == null || (length = digits.length()) == 0)
            return Collections.emptyList();
        if (length == 1)
            return single(digits);
        return recursive(new ArrayList<>((int) Math.pow(4, length)), digits, new byte[length], 0);
    }

}
