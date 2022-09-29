package org.gd.leetcode.p0791;

import org.gd.leetcode.common.LeetCode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/custom-sort-string/">LeetCode #791: Custom Sort String</a>
 *
 * @author Horkhover Dmytro
 * @since 2022-09-29
 */
@LeetCode(
        name = "Custom Sort String",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.STRING,
                LeetCode.Tags.HASH_TABLE,
                LeetCode.Tags.SORT
        }
)
class Solution {

    private int[] orders;

    public String customSortString(String order, String s) {
        orders = new int[(1 << 7) + 1];
        for (int i = 0; i < order.length(); i++) {
            orders[order.charAt(i)] = i + 1;
        }

        Character[] boxedChars = new Character[s.length()];
        for (int i = 0; i < boxedChars.length; i++) {
            boxedChars[i] = s.charAt(i);
        }

        Arrays.sort(boxedChars, this::compareChars);
        char[] chars = new char[boxedChars.length];
        for (int i = 0; i < boxedChars.length; i++) {
            chars[i] = boxedChars[i];
        }

        return new String(chars);
    }

    private int compareChars(Character c1, Character c2) {
        int o1 = orders[c1] == 0 ? Integer.MAX_VALUE : orders[c1];
        int o2 = orders[c2] == 0 ? Integer.MAX_VALUE : orders[c2];
        return Integer.compare(o1, o2);
    }
}
