package org.gd.hackerrank.other;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lombok.NonNull;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import javax.annotation.Nonnull;

/**
 * Test for {@link VeryBigSum}
 *
 * @since 2019-09-20
 */
class VeryBigSumTest {

    @Nonnull
    static Stream<Arguments> args() {
        return Stream.of(
            Arguments.of(new long[]{1000000001L, 1000000002L, 1000000003L, 1000000004L, 1000000005L}, 5000000015L)
        );
    }

    /**
     * Test for {@link VeryBigSum#aVeryBigSum(long[])}
     */
    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Solution")
    void test_AVeryBigSum(@NonNull long[] arr, long expected) throws Exception {
        long actual = VeryBigSum.aVeryBigSum(arr);
        assertEquals(expected, actual);
    }

    /**
     * Test for {@link VeryBigSum#forLoopSolution(long[])}
     */
    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Loop Solution")
    void test_Loop(@NonNull long[] arr, long expected) throws Exception {
        long actual = VeryBigSum.forLoopSolution(arr);
        assertEquals(expected, actual);
    }

    /**
     * Test for {@link VeryBigSum#streamSolution(long[])}
     */
    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Stream Solution")
    void test_Stream(@NonNull long[] arr, long expected) throws Exception {
        long actual = VeryBigSum.streamSolution(arr);
        assertEquals(expected, actual);
    }
}
