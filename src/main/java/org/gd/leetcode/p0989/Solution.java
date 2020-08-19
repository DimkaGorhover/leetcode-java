package org.gd.leetcode.p0989;

import org.gd.leetcode.common.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/add-to-array-form-of-integer/
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0066.Solution
 * @since 2020-08-19
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Add to Array-Form of Integer",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = LeetCode.Tags.ARRAY
)
class Solution {

    public List<Integer> addToArrayForm(int[] A, final int K) {

        if (K == 0) {
            List<Integer> list = new ArrayList<>(A.length);
            for (int i : A)
                list.add(i);
            return list;
        }

        if (A == null)
            A = new int[0];

        LinkedList<Integer> list = new LinkedList<>();
        int prev = K;
        for (int i = A.length - 1; i >= 0 || prev > 0; i--) {
            int sum = prev + (i >= 0 ? A[i] : 0);
            list.addFirst(sum % 10);
            prev = sum / 10;
        }
        return list;
    }
}
