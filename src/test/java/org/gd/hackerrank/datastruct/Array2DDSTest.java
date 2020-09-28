package org.gd.hackerrank.datastruct;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Array2DDS}
 *
 * @author Horkhover Dmytro
 * @since 2020-09-27
 */
class Array2DDSTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(19, new int[][]{
                        {1, 1, 1, 0, 0, 0},
                        {0, 1, 0, 0, 0, 0},
                        {1, 1, 1, 0, 0, 0},
                        {0, 0, 2, 4, 4, 0},
                        {0, 0, 0, 2, 0, 0},
                        {0, 0, 1, 2, 4, 0}
                })
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void hourglassSum(int expected, int[][] arr) {
        int actual = Array2DDS.hourglassSum(arr);
        assertEquals(expected, actual);
    }
}
