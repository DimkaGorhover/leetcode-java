package org.gd.leetcode.p0009;

public class Solution {

    public boolean isPalindrome(int x) {
        final String s1 = String.valueOf(x);
        final String s2 = new StringBuilder().append(x).reverse().toString();
        return s1.equals(s2);
    }
}
