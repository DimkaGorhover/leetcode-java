package org.gd.leetcode.p0374;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 */
@DisplayName("LeetCode #374: Guess Number Higher or Lower")
@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.concat(
                Stream.of(
                        Arguments.of(0, 0),
                        Arguments.of(10, 10)
                ),
                IntStream.range(0, 1 << 5)
                        .mapToObj(value -> {
                            int n = ThreadLocalRandom.current().nextInt(0, 1 << 15);
                            int guess = ThreadLocalRandom.current().nextInt(0, n);
                            return Arguments.of(n, guess);
                        })
        );
    }

    @ParameterizedTest(name = "{displayName} #{index}. n = {0}, guess = {1}")
    @MethodSource("args")
    @DisplayName("Guess Number")
    void guessNumber(int n, int guess) {

        int res = new Solution() {

            @Override
            int guess(int n) { return Integer.compare(guess, n); }

        }.guessNumber(n);

        assertEquals(guess, res);
    }
}
