package org.gd.hackerrank.other;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CounterGameTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(562949953421312L, "Louise"),
                Arguments.of(946351374926454L, "Richard"),
                Arguments.of(611675058145995L, "Louise"),
                Arguments.of(1120808395487463L, "Richard"),
                Arguments.of(602842249454153L, "Louise"),
                Arguments.of(2147483648L, "Louise")
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void counterGame(long n, String expected) {
        assertEquals(expected, CounterGame.counterGame(n));
    }
}