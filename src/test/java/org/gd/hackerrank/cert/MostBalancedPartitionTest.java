package org.gd.hackerrank.cert;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MostBalancedPartitionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList(-1, 0, 0, 1, 1, 2),
                        Arrays.asList(1, 2, 2, 1, 1, 1),
                        0),
                Arguments.of(
                        Arrays.asList(-1, 0, 1, 2),
                        Arrays.asList(1, 4, 3, 4),
                        2)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void mostBalancedPartition(List<Integer> parentIndices, List<Integer> filesSizes, int expected) {
        int actual = MostBalancedPartition.mostBalancedPartition(parentIndices, filesSizes);
        assertEquals(expected, actual);
    }
}