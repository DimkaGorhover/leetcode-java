package org.gd.hackerrank.other;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Test for {@link BiggerIsGreater}
 *
 * @since 2019-09-23
 */
@Execution(ExecutionMode.CONCURRENT)
class BiggerIsGreaterTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments("ab", "ba"),
                arguments("bb", "no answer"),
                arguments("hefg", "hegf"),
                arguments("dhck", "dhkc"),
                arguments("lmno", "lmon"),
                arguments("dcba", "no answer"),
                arguments("dcbb", "no answer"),
                arguments("abcd", "abdc"),
                arguments("fedcbabcd", "fedcbabdc"),
                arguments("dkhc", "hcdk"),
                arguments("abdc", "acbd")
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("BiggerIsGreater")
    void test_BiggerIsGreater(String input, String expected) throws Exception {

        String actual = BiggerIsGreater.biggerIsGreater(input);

        assertEquals(expected, actual, () -> {
            String s1 = String.format("input   : %s%n", input);
            String s2 = String.format("expected: %s%n", expected);
            String s3 = String.format("actual  : %s%n", actual);
            return String.format("%n%s%s%s%n", s1, s2, s3);
        });
    }
}