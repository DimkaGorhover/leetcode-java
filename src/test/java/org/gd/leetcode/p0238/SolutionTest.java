package org.gd.leetcode.p0238;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.gd.common.CollectionUtils.listOf;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @since 2019-10-09
 */
@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
@DisplayName("LeetCode #238: Product of Array Except Self")
class SolutionTest {

    private static Stream<Arguments> generatedArgs() {

        return IntStream.rangeClosed(4, 20)
                .map(operand -> 1 << operand)
                .mapToObj(length -> {
                    int[] arr = TestUtils.randomArray(length);
                    return Arguments.of(arr, TestUtils.solution(arr));
                });
    }

    private static Stream<Arguments> customArgs() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4}, new int[]{24, 12, 8, 6}),
                Arguments.of(new int[]{1, 0}, new int[]{0, 1})
        );
    }

    private static Stream<Arguments> args() {

        return Stream.concat(generatedArgs(), customArgs());
    }

    @ParameterizedTest(name = "ProductExceptSelf #{index}")
    @MethodSource("args")
    @DisplayName("ProductExceptSelf")
    void test_ProductExceptSelf(int[] nums, int[] expected) {
        assertEquals(
                listOf(expected),
                listOf(new Solution().productExceptSelf(nums)));
    }
}