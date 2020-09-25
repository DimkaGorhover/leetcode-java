package org.gd.leetcode.p0331;

import org.gd.common.CollectionUtils;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Horkhover Dmytro
 * @since 2020-09-25
 */
class SolutionTest {

    @Test
    void isValidSerialization() {
    }

    @Test
    void testIterator() {
        Solution.StringItr stringItr = new Solution.StringItr("-1 ,2, -3,-4");

        assertEquals(List.of(-1, 2, -3, -4), CollectionUtils.listOf(stringItr));

    }
}