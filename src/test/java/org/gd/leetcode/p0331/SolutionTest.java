package org.gd.leetcode.p0331;

import lombok.var;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.gd.leetcode.common.CollectionUtils.listOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @since 2020-09-25
 */
@DisplayName("LeetCode #331: Verify Preorder Serialization of a Binary Tree")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of("1,#", false),
                Arguments.of("9,3,4,#,#,1,#,#,2,#,6,#,#", true),
                Arguments.of("9,#,#,1", false)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("IsValidSerialization")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_IsValidSerialization(String preorder, boolean expected) {
        assertEquals(expected, new Solution().isValidSerialization(preorder));
    }

    @Test
    @DisplayName("String Iterator")
    void test_Next() {

        var itr = new Solution.StringItr("-1 ,2,#,-3,-4");

        assertEquals(Arrays.asList(-1, 2, null, -3, -4), listOf(itr));
    }
}