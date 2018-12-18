package org.gd.leetcode.p0470;

/**
 * https://leetcode.com/problems/implement-rand10-using-rand7
 *
 * @author Horkhover Dmytro
 * @since 2018-12-18
 */
class Solution extends SolBase {

    private static final double C = 10.0 / 7.0;

    public int rand10() { return (rand7() << rand7()) % 10; }

    public int rand10(int rand7) { return (int) (rand7 * C);}
}
