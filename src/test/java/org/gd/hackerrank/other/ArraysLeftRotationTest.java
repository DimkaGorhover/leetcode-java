package org.gd.hackerrank.other;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ArraysLeftRotationTest {

    private static List<Integer> toList(int[] arr) {
        if (arr == null || arr.length == 0)
            return Collections.emptyList();
        if (arr.length == 1)
            return Collections.singletonList(arr[0]);
        return Arrays.stream(arr).boxed().collect(Collectors.toList());
    }

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

        int[] actual = ArraysLeftRotation.rotLeft(input, r);

        assertEquals(toList(expected), toList(actual));
    }
}