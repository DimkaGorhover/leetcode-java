package org.gd.leetcode.p0043;

import org.gd.common.ArrayUtils;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigInteger;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @author Gorkhover D.
 * @since 2018-10-22
 */
@DisplayName("LeetCode #43: Multiply Strings")
@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Supplier<Arguments> arguments(String v1, String v2) {

        requireNonNull(v1, "\"v1\" cannot be null");
        requireNonNull(v2, "\"v2\" cannot be null");

        return () -> {

            BigInteger b1 = new BigInteger(v1, 10);
            BigInteger b2 = new BigInteger(v2, 10);

            String expected = b1.multiply(b2).toString(10);

            return Arguments.of(v1, v2, expected);
        };
    }

    private static Supplier<Arguments> random() {
        return () -> {

            char[] arr = new char[ThreadLocalRandom.current().nextInt(10, 20)];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (char) ((i % 10) + '0');
            }

            ArrayUtils.shuffle(arr);
            String v1 = new String(arr);

            ArrayUtils.shuffle(arr);
            String v2 = new String(arr);

            return arguments(v1, v2).get();
        };
    }

    private static Stream<Arguments> args() {
        return Stream.of(

                () -> Arguments.of("0", "135", "0"),

                arguments("2", "3"),
                arguments("9", "9"),
                arguments("123", "456"),
                arguments("427", "36"),
                arguments("421279817323491397", "36830958262320980"),

                random(),
                random(),
                random()

        ).map(Supplier::get);
    }

    @ParameterizedTest(name = "{0} x {1} = {2}")
    @MethodSource("args")
    void multiply(String v1, String v2, String expected) {
        assertEquals(expected, new Solution().multiply(v1, v2));
    }
}
