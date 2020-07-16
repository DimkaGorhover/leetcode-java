package org.gd.hackerrank.other.array;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.gd.common.ArrayUtils.copy;
import static org.gd.common.CollectionUtils.listOf;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Arrays: Left Rotation")
class ArraysLeftRotationTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 2, new int[]{3, 4, 5, 1, 2}),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 7, new int[]{3, 4, 5, 1, 2})
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Arrays: Left Rotation")
    void rotLeft(int[] input, int r, int[] expected) {

        int[] actual = ArraysLeftRotation.rotLeft(copy(input), r);

        assertEquals(listOf(expected), listOf(actual));
    }
}