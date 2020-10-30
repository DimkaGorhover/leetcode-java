package org.gd.joma.pi;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * Test for {@link PiCalculator}
 *
 * @author Horkhover Dmytro
 * @since 2020-08-08
 */
@DisplayName("Task from Joma: Calculating PI from uniform random")
class PiCalculatorTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(1L << 20, 1 << 10),
                Arguments.of(1L << 20, 1 << 6),
                Arguments.of(1L << 20, 1 << 8),
                Arguments.of(1L << 20, 1 << 4),
                Arguments.of(1L << 20, 1 << 12),
                Arguments.of(1L << 20, 1 << 13)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Calc")
    void test_Calc(long count, int batchSize) {
        PiCalculator calculator = new StreamPiCalculator(batchSize);
        int powOf2 = (int) (Math.log10(count) / Math.log10(2));
        System.out.printf("PI(~(2^%d)) = %1.6f%n", powOf2, calculator.calc(count));
    }
}
