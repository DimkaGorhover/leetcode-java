package org.gd.leetcode.p0374;

import org.junit.jupiter.api.*;

class SolutionTest {

    @Test
    void guessNumber() {

        int res = new Solution() {

            @Override
            int guess(int n) { return Integer.compare(6, n); }

        }.guessNumber(10);

        System.out.println(res);
    }
}