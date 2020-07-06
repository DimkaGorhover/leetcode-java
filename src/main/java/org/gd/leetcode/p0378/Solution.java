package org.gd.leetcode.p0378;

import org.gd.leetcode.common.LeetCode;

/*

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return -1;
        }

        int len = matrix.length;
        int left = matrix[0][0], right = matrix[len - 1][len - 1];

        while (left < right) {
            int mid = (right - left) / 2 + left;
            int cnt = countNum(matrix, mid);
            if (cnt < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    private static int countNum(int[][] matrix, int target) {
        int len = matrix.length;
        int res = 0;
        int i = len - 1, j = 0;
        while (i >= 0 && j < len) {
            if (matrix[i][j] <= target) {
                res += i + 1;
                j++;
            } else i--;
        }
        return res;
    }
}
 */

/**
 * FIXME: https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 *
 * @author Horkhover Dmytro
 * @since 2018-11-18
 */
@LeetCode(
        name = "kth smallest element in a sorted matrix",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.TODO,
        tags = {
                LeetCode.Tags.BINARY_SEARCH,
                LeetCode.Tags.HEAP
        })
class Solution {

    public int kthSmallest(int[][] matrix, int k) {
        throw new UnsupportedOperationException(new String(new char[]{175, 92, 95, 40, 12_484, 41, 95, 47, 175}));
    }
}
