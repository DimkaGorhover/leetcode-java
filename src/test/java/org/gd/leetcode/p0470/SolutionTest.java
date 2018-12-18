package org.gd.leetcode.p0470;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution};
 *
 * @author Horkhover Dmytro
 * @since 2018-12-18
 */
class SolutionTest {

    @Test
    @DisplayName("Rand10")
    void test_Rand10() {

        System.out.println(new Solution().rand10());

        System.out.println(new Solution().rand10(1));
    }
}