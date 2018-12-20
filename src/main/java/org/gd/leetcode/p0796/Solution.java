package org.gd.leetcode.p0796;

/**
 * https://leetcode.com/problems/rotate-string/
 *
 * @author Horkhover Dmytro
 * @since 2018-12-20
 */
class Solution {

    public boolean rotateString(String A, String B) {
        return A != null && B != null
                && A.length() == B.length()
                && (A + A).contains(B);
    }
}
