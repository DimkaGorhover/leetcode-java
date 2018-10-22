package org.gd.leetcode.p0043;

import java.math.BigInteger;

/**
 * @author Gorkhover D.
 * @since 2018-10-22
 */
class Solution {

    public String multiply(String num1, String num2) {
        return new BigInteger(num1, 10).multiply(new BigInteger(num2, 10)).toString(10);
    }
}
