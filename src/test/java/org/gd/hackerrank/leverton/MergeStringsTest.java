package org.gd.hackerrank.leverton;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Test for {@link MergeStrings};
 *
 * @author Horkhover Dmytro
 * @since 2019-03-06
 */
class MergeStringsTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments("abc", "def", "adbecf")
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("MergeStrings")
    void test_MergeStrings(String a, String b, String expected) {
        assertEquals(expected, MergeStrings.mergeStrings(a,b));
    }
}