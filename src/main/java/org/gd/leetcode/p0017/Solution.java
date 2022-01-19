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
                LeetCode.Tags.HASH_TABLE,
                LeetCode.Tags.STRING,
                LeetCode.Tags.BACKTRACKING
        }
)
class Solution {

    private static final char[][] VALUES = {
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

    private ArrayList<String> list;
    private int length;
    private String digits;
    private char[] chars;

    public List<String> letterCombinations(String digits) {
        this.digits = digits;
        if (digits == null || (length = digits.length()) == 0) {
            return Collections.emptyList();
        }

        if (length == 1) {
            return single();
        }

        this.list = new ArrayList<>((int) Math.pow(4, length));
        this.chars = new char[length];

        recursive(0);

        return list;
    }

    private char[] chars(int pos) {
        return VALUES[digits.charAt(pos) - '0'];
    }

    private void recursive(int pos) {
        int last = length - 1;
        if (pos > last) {
            return;
        }

        if (pos == last) {
            for (char c : chars(pos)) {
                chars[last] = c;
                list.add(new String(chars));
            }
            return;
        }

        final int nextPos = pos + 1;
        for (char c : chars(pos)) {
            chars[pos] = c;
            recursive(nextPos);
        }
    }

    private List<String> single() {
        final char[] chars = chars(0);
        final List<String> strings = new ArrayList<>(length);
        for (char c : chars) {
            strings.add("" + c);
        }
        return strings;
    }
}
