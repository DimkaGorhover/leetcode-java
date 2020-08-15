package org.gd.leetcode.p0278;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/first-bad-version/
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0704.Solution
 * @see java.util.Arrays#binarySearch(int[], int)
 * @since 2020-08-15
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "First Bad Version",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = LeetCode.Tags.BINARY_SEARCH
)
abstract class Solution extends VersionControl {

    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (isBadVersion(mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
