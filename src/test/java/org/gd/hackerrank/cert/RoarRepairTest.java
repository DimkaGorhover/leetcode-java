package org.gd.hackerrank.cert;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RoarRepairTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList(5, 3, 1, 4, 6),
                        Arrays.asList(9, 8, 3, 15, 1),
                        17
                ),
                Arguments.of(
                        Arrays.asList(4, 4, 7, 9, 10),
                        Arrays.asList(4, 5, 1, 4, 2),
                        18
                ),
                Arguments.of(
                        Arrays.asList(6, 5, 9, 4, 3, 8, 2),
                        Arrays.asList(6, 9, 8, 1, 10, 1, 4),
                        -1
                )
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void getMinCost(List<Integer> crew_id, List<Integer> job_id, int expected) {
        long actual = RoarRepair.getMinCost(crew_id, job_id);
        assertEquals(expected, actual);
    }
}
