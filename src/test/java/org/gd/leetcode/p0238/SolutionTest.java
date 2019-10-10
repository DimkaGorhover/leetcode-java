package org.gd.leetcode.p0238;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.parallel.ExecutionMode.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Test for {@link Solution}
 *
 * @since 2019-10-09
 */
@Execution(CONCURRENT)
class SolutionTest {

    private static int[] randomArray(int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++)
            array[i] = ThreadLocalRandom.current().nextInt(0, 100);
        return array;
    }

    private static int linearProd(int[] nums, int pos) {
        int prod = 1;
        for (int i = 0; i < nums.length; i++)
            prod *= (i == pos ? 1 : nums[i]);
        return prod;
    }

    private static int[] linearSolution(int[] nums) {
        int[] prods = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            prods[i] = linearProd(nums, i);
        return prods;
    }

    private static int streamProd(int[] nums, int pos) {
        IntStream stream1 = Arrays.stream(nums, 0, pos).parallel();
        IntStream stream2 = Arrays.stream(nums, pos + 1, nums.length).parallel();
        return IntStream.concat(stream1, stream2)
                .parallel()
                .reduce(1, (left, right) -> left * right);
    }

    private static int[] streamSolution(int[] nums) {
        return IntStream.range(0, nums.length).parallel()
                .map(i -> streamProd(nums, i))
                .toArray();
    }

    private static int[] solution(int[] nums) {
        return nums.length < 1 << 10 ? linearSolution(nums) : streamSolution(nums);
    }

    private static Stream<Arguments> args() {

        Stream<Arguments> stream1 = IntStream.rangeClosed(1, 15)
                .map(operand -> 1 << operand)
                .mapToObj(length -> {
                    int[] arr = randomArray(length);
                    return arguments(arr, solution(arr));
                });

        Stream<Arguments> stream2 = Stream.of(
                arguments(new int[]{1, 2, 3, 4}, new int[]{24, 12, 8, 6}),
                arguments(new int[]{1, 0}, new int[]{0, 1})
        );

        return Stream.concat(stream1, stream2);
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("ProductExceptSelf")
    void test_ProductExceptSelf(int[] nums, int[] expected) throws Exception {
        assertArrayEquals(expected, new Solution().productExceptSelf(nums));
    }
}