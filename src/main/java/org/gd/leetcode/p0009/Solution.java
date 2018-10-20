package org.gd.leetcode.p0009;

class Solution {

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        else if (x < 10) return true;
        int num = x, reverse = 0;
        do { reverse = (reverse * 10) + (num % 10); } while ((num /= 10) > 0);
        return x == reverse;
    }
}
