package org.gd.leetcode.p0165;

import org.gd.leetcode.common.Difficulty;

/**
 * https://leetcode.com/problems/compare-version-numbers/
 *
 * @author Horkhover Dmytro
 * @since 2018-12-18
 */
@Difficulty(Difficulty.Level.MEDIUM)
class Solution {

    public int compareVersion(String version1, String version2) {
        char c;
        int  l1 = version1.length(), l2 = version2.length(), res = 0, pos1 = 0, pos2 = 0, v1, v2;
        while (res == 0 && (pos1 < l1 || pos2 < l2)) {
            v1 = 0;
            v2 = 0;
            while (pos1 < l1 && (c = version1.charAt(pos1++)) != '.') v1 = v1 * 10 + (c - 48);
            while (pos2 < l2 && (c = version2.charAt(pos2++)) != '.') v2 = v2 * 10 + (c - 48);
            res = Integer.compare(v1, v2);
        }
        return res;
    }
}
