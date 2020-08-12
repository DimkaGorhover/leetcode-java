package org.gd.joma;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link CalculatePI}
 *
 * @author Horkhover Dmytro
 * @since 2020-08-08
 */
@DisplayName("Task from Joma: Calculating PI from uniform random")
class CalculatePITest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(1L << 20)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Calc")
    void test_Calc(long count) {
        System.out.printf("PI() = %1.6f%n", CalculatePI.calc(count));
    }
}
