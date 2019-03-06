package org.gd.hackerrank.leverton;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Test for {@link CutSticks};
 *
 * @author Horkhover Dmytro
 * @since 2019-03-06
 */
class CutSticksTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments(List.of(6, 5, 4, 4, 2, 2, 8), List.of(6, 4, 2, 1))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("CutSticks")
    void test_CutSticks(List<Integer> list, List<Integer> expected) {
        assertEquals(expected, CutSticks.cutSticks(list));
    }
}