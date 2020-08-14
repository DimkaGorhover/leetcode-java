package org.gd.leetcode.p1002;

import org.gd.leetcode.common.LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/find-common-characters/
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0349.Solution
 * @see org.gd.leetcode.p0350.Solution
 * @since 2020-08-14
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Find Common Characters",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.HASH_TABLE
        }
)
class Solution {

    private static int[] toArr(String s) {
        int[] arr = new int['z' - 'a' + 1];
        for (int i = 0; i < s.length(); i++)
            arr[s.charAt(i) - 'a']++;
        return arr;
    }

    private static int min(int[] ints1, int[] ints2) {
        int count = 0;
        for (int i = 0; i < ints1.length; i++) {
            if ((ints1[i] = Math.min(ints1[i], ints2[i])) > 0)
                count++;
        }
        return count;
    }

    public List<String> commonChars(String[] A) {
        int[] arr = toArr(A[0]);
        int count = 0;
        for (int i = 1; i < A.length; i++)
            count = min(arr, toArr(A[i]));


        if (count == 0)
            return Collections.emptyList();

        List<String> strings = new ArrayList<>(count);
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] > 0) {
                strings.add(Character.toString(i + 'a'));
                arr[i]--;
            }
        }

        return strings;
    }
}
