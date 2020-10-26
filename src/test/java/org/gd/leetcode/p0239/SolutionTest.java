package org.gd.leetcode.p0239;

import org.gd.common.IOUtils;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.gd.common.CollectionUtils.listOf;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution};
 *
 * @author Gorkhover D.
 * @since 2018-11-02
 */
@Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
@DisplayName("LeetCode #239: Sliding Window Maximum")
class SolutionTest {

    private static int[] intArray(String[] arr) {
        return Arrays.stream(arr)
                .mapToInt(value -> Integer.parseInt(value.trim()))
                .toArray();
    }

    private static Stream<Arguments> testCase001() {

        List<String> fileNames = List.of(
                "test_case_001.txt"
        );

        return fileNames.stream()
                .map(fileName -> {
                    try (var resource = IOUtils.resource(SolutionTest.class, fileName)) {

                        int[] ints = intArray(resource.readLine().split(","));
                        int k = Integer.parseInt(resource.readLine().trim());
                        int[] expected = intArray(resource.readLine().split(","));

                        return Arguments.of(ints, k, expected);

                    } catch (Throwable e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    private static Stream<Arguments> args() {

        return Stream.concat(
                Stream.of(
                        Arguments.of(new int[]{9, 10, 9, -7, -4, -8, 2, -6}, 5, new int[]{10, 10, 9, 2}),
                        Arguments.of(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3, new int[]{3, 3, 5, 5, 6, 7})
                ),
                testCase001()
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("TreeMapSolution")
    void test_TreeMapSolution(int[] input, int k, int[] expected) {
        assertEquals(
                listOf(expected),
                listOf(new TreeMapSolution().maxSlidingWindow(input, k)));
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("DequeSolution")
    void test_DequeSolution(int[] input, int k, int[] expected) {
        assertEquals(
                listOf(expected),
                listOf(new DequeSolution().maxSlidingWindow(input, k)));
    }
}