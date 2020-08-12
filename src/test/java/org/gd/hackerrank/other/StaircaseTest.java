package org.gd.hackerrank.other;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Test for {@link Staircase}
 *
 * @author Horkhover Dmytro
 * @since 2018-11-18
 */
class StaircaseTest {

    @Test
    @DisplayName("Staircase")
    void test_Staircase() throws IOException {

        synchronized (System.out) {

            var prevOut = System.out;
            var prevErr = System.err;

            try (var baos = new ByteArrayOutputStream();
                 var ps = new PrintStream(baos)) {

                System.setOut(ps);
                System.setErr(ps);

                Staircase.staircase(6);

                System.setOut(prevOut);
                System.setErr(prevErr);

                ps.flush();
                baos.flush();

                System.out.println(baos.toString());
            }
        }
    }
}