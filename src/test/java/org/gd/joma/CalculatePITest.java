package org.gd.joma;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link CalculatePI}
 *
 * @author Horkhover Dmytro
 * @since 2020-08-08
 */
@DisplayName("Task from Joma: Calculating PI from uniform random")
class CalculatePITest {

    @Test
    @DisplayName("Calc")
    void test_Calc() {
        System.out.printf("%1.6f%n", CalculatePI.calc(1L << 20));
        System.out.printf("%1.6f%n", CalculatePI.calc(1L << 19));
    }
}
