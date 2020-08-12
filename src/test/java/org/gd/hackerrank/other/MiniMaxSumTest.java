package org.gd.hackerrank.other;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link MiniMaxSum}
 *
 * @author Horkhover Dmytro
 * @since 2020-08-12
 */
class MiniMaxSumTest {

    @Test
    @DisplayName("MiniMaxSum")
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    void test_MiniMaxSum() throws IOException {

        synchronized (System.out) {

            var prevOut = System.out;
            var prevErr = System.err;

            var baos = new ByteArrayOutputStream();
            var ps = new PrintStream(baos);

            System.setOut(ps);
            System.setErr(ps);

            // test

            MiniMaxSum.miniMaxSum(new int[]{1, 2, 3, 4, 5});

            System.setOut(prevOut);
            System.setErr(prevErr);

            ps.flush();
            baos.flush();
            ps.close();
            baos.close();

            assertEquals("10 14", baos.toString().trim());

        }
    }
}