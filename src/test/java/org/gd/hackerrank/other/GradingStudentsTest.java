package org.gd.hackerrank.other;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link GradingStudents}
 *
 * @author Horkhover Dmytro
 * @since 2020-08-12
 */
@DisplayName("HackerRank: Grading Students")
class GradingStudentsTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(
                        List.of(73, 67, 38, 33),
                        List.of(75, 67, 40, 33))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("GradingStudents")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_GradingStudents(List<Integer> grades, List<Integer> expected) {
        assertEquals(expected, GradingStudents.gradingStudents(grades));
    }
}