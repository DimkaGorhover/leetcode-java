package org.gd.leetcode.p1006;

/**
 * @author Horkhover Dmytro
 * @since 2020-07-31
 */
class LoopSolution implements Solution {

    @Override
    public int clumsy(int N) {

        int sum = 0;
        int i = N;
        int sign = 1;

        while (i > 0) {

            int f = sign * i;
            i--;

            if (i > 0) {
                f = f * i;
                i--;
            } else {
                sum += f;
                break;
            }

            if (i > 0) {
                f = f / i;
                i--;
            } else {
                sum += f;
                break;
            }

            if (i > 0) {
                f = f + i;
                i--;
            } else {
                sum += f;
                break;
            }

            sum += f;
            sign = -1;
        }

        return sum;
    }
}
