package org.gd.leetcode.p0279;

/**
 * @author Horkhover Dmytro
 * @since 2020-07-22
 */
class MathSolution implements Solution {

    @Override
    public int numSquares(int n) {
        while (n % 4 == 0)
            n /= 4;

        if (n % 8 == 7)
            return 4;

        if (isSquare(n))
            return 1;

        for (int i = 1; i * i <= n; i++) {
            if (isSquare(n - i * i)) {
                return 2;
            }
        }
        return 3;
    }

    private static boolean isSquare(int num) {
        final int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }
}
