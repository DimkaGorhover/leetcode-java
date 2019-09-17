package org.gd.google;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Test for {@link CountingSheep}
 *
 * @since 2019-09-16
 */
class CountingSheepTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments(0, "INSOMNIA"),
                arguments(1, "10"),
                arguments(2, "90"),
                arguments(10, "90"),
                arguments(1692, "5076")
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Counting")
    void test_Counting(int n, String expected) throws Exception {
        assertEquals(expected, new CountingSheep().counting(n));
    }
}