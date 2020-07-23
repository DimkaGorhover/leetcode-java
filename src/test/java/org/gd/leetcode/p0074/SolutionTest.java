package org.gd.leetcode.p0074;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @since 2020-07-23
 */
@DisplayName("LeetCode 74: Search a 2D Matrix")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[][]{
                        {1, 3, 5, 7},
                        {10, 11, 16, 20},
                        {23, 30, 34, 50}}, 13, false),
                Arguments.of(new int[][]{
                        {1, 3, 5, 7},
                        {10, 11, 16, 20},
                        {23, 30, 34, 50}}, 0, false),
                Arguments.of(new int[][]{
                        {1, 3, 5, 7},
                        {10, 11, 16, 20},
                        {23, 30, 34, 50}}, 51, false),
                Arguments.of(new int[][]{
                        {1, 3, 5, 7},
                        {10, 11, 16, 20},
                        {23, 30, 34, 50}}, 3, true),
                Arguments.of(new int[][]{
                        {1, 3, 5, 7},
                        {10, 11, 16, 20},
                        {23, 30, 34, 50}}, 15, false)
        );
    }

    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("DFSSolution")
    void test_DFSSolution(int[][] matrix, int target, boolean expected) {
        assertEquals(expected, new DFSSolution().searchMatrix(matrix, target));
    }

    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("BinarySearchSolution")
    void test_BinarySearchSolution(int[][] matrix, int target, boolean expected) {
        assertEquals(expected, new BinarySearchSolution().searchMatrix(matrix, target));
    }

    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("LinearSolution")
    void test_LinearSolution(int[][] matrix, int target, boolean expected) {
        assertEquals(expected, new LinearSolution().searchMatrix(matrix, target));
    }
}