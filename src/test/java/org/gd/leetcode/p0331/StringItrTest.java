package org.gd.leetcode.p0331;

import org.junit.jupiter.api.*;

import java.util.Arrays;

import static org.gd.common.CollectionUtils.listOf;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution.StringItr}
 *
 * @author Horkhover Dmytro
 * @since 2020-09-25
 */
@DisplayName("Test for org.gd.leetcode.p0331.Solution.StringItr")
class StringItrTest {

    @Test
    @DisplayName("Next")
    void test_Next() {

        var itr = new Solution.StringItr("-1 ,2,#,-3,-4");

        assertEquals(Arrays.asList(-1, 2, null, -3, -4), listOf(itr));
    }
}