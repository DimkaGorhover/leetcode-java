package org.gd.leetcode.p1137;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void tribonacci() {
        for (int i = 0; i < 10; i++) {
            int value = new Solution().tribonacci(i);
            System.out.printf("%d --> %d%n", i, value);
        }
    }
}

/*
0
1
1
2
4
7
 */