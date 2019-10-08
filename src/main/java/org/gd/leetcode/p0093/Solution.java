package org.gd.leetcode.p0093;

import org.gd.leetcode.common.LeetCode;

import java.util.*;

/**
 * https://leetcode.com/problems/restore-ip-addresses/
 *
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 *
 * <pre><code>
 *
 * Example:
 *
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 *
 * </code></pre>
 *
 * @author Gorkhover D.
 * @since 2018-10-23
 */
@LeetCode(difficulty = LeetCode.Level.MEDIUM, tags = {LeetCode.Tags.STRING, LeetCode.Tags.BACKTRACKING})
class Solution {

    private static boolean valid(int value) { return 0 <= value && value <= 255; }

    private static int toInt(char c) { return c - '0'; }

    private static int read(String s, int offset, int length) {
        if (s.length() - offset < length)
            return -1;
        switch (length) {
            case 1: {
                return toInt(s.charAt(offset));
            }
            case 2: {
                int c1 = toInt(s.charAt(offset));
                return c1 == 0 ? -1 : (c1 * 10) + toInt(s.charAt(offset + 1));
            }
            case 3: {
                int c1 = toInt(s.charAt(offset));
                return c1 == 0 ? -1 : (c1 * 100) + (toInt(s.charAt(offset + 1)) * 10) + toInt(s.charAt(offset + 2));
            }
        }
        return -1;
    }

    private static void part1(Set<String> list, String s) {
        for (int i = 1; i <= 3; i++) {
            int i1 = read(s, 0, i);
            if (valid(i1))
                part2(list, i1, s, i);
        }
    }

    private static void part2(Set<String> list, int i1, String s, int offset) {
        for (int i = 1; i <= 3; i++) {
            int i2 = read(s, offset, i);
            if (valid(i2))
                part3(list, i1, i2, s, offset + i);
        }
    }

    private static void part3(Set<String> list, int i1, int i2, String s, int offset) {
        for (int i = 1; i <= 3; i++) {
            int i3 = read(s, offset, i);
            if (valid(i3))
                part4(list, i1, i2, i3, s, offset + i);
        }
    }

    private static void part4(Set<String> list, int i1, int i2, int i3, String s, int offset) {
        int i4 = read(s, offset, (s.length() - offset));
        if (valid(i4))
            list.add(i1 + "." + i2 + "." + i3 + "." + i4);
    }

    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12)
            return Collections.emptyList();
        HashSet<String> set = new HashSet<>();
        part1(set, s);
        return new ArrayList<>(set);
    }
}
