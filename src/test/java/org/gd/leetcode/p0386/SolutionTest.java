package org.gd.leetcode.p0386;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void lexicalOrder() {

        System.out.println(
                new Solution().lexicalOrder(130)
        );

        assertEquals(
                java.util.Arrays.asList(1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9),
                new Solution().lexicalOrder(13)
        );

        assertEquals(
                java.util.Arrays.asList(1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 2, 20, 3, 4, 5, 6, 7, 8, 9),
                new Solution().lexicalOrder(20)
        );
    }
}