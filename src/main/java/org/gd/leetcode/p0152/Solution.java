package org.gd.leetcode.p0152;

import org.gd.common.Repeat;
import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/maximum-product-subarray/
 *
 * @author Horkhover D.
 * @see org.gd.leetcode.p0053.Solution
 * @see org.gd.leetcode.p0628.Solution
 * @since 2020-06-30
 */
@Repeat("DYNAMIC_PROGRAMMING")
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Maximum Product Subarray",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.DYNAMIC_PROGRAMMING,
                LeetCode.Tags.ARRAY
        }
)
class Solution {

    private static int max(int v1, int v2) {
        return Math.max(v1, v2);
    }

    private static int max(int v1, int v2, int v3) {
        return max(v1, max(v2, v3));
    }

    private static int min(int v1, int v2, int v3) {
        return Math.min(v1, Math.min(v2, v3));
    }

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return max(nums[0], nums[1], nums[0] * nums[1]);

        int min = nums[0];
        int max = nums[0];
        int maxProduct = nums[0];
        for (int i = 1, n = nums.length; i < n; i++) {

            int currentMaxProduct = nums[i] * max;
            int currentMinProduct = nums[i] * min;

            max = max(nums[i], currentMaxProduct, currentMinProduct);
            min = min(nums[i], currentMaxProduct, currentMinProduct);

            maxProduct = max(maxProduct, max);
        }

        return maxProduct;
    }
}
