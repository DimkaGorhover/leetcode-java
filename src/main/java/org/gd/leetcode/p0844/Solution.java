package org.gd.leetcode.p0844;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/backspace-string-compare/
 */
@LeetCode(
        name = "Backspace String Compare",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.TWO_POINTERS,
                LeetCode.Tags.STRING
        }
)
class Solution {

    private int handle(char[] arr, String text) {
        if (arr.length == 0)
            return 0;
        if (arr.length == 1 && text.charAt(0) == '#')
            return 0;
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            char c = text.charAt(i);
            if (c == '#') {
                j = Math.max(0, j - 1);
            } else {
                arr[j++] = c;
            }
        }
        return j;
    }

    public boolean backspaceCompare(String S, String T) {

        if (S == null) return T == null;
        if (T == null) return false;

        if (S.isEmpty()) return T.isEmpty();
        if (T.isEmpty()) return false;

        final char[] arr0 = new char[S.length()];
        final char[] arr1 = new char[T.length()];

        final int l0 = handle(arr0, S);
        final int l1 = handle(arr1, T);

        if (l0 != l1)
            return false;

        for (int i = 0; i < l0; i++) {
            if (arr0[i] != arr1[i])
                return false;
        }

        return true;
    }
}
