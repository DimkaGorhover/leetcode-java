package org.gd.leetcode.p1116;

import lombok.var;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link ZeroEvenOdd}
 */
@DisplayName("LeetCode #1116: Print Zero Even Odd")
class ZeroEvenOddTest {

    @Test
    void test() throws InterruptedException {
        var odd = new ZeroEvenOdd(4);
        var q   = new LinkedBlockingQueue<Integer>();

        var executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (int i = 0; i < 5; i++) {
            executor.execute((TestRunnable) () -> odd.zero(q::add));
            executor.execute((TestRunnable) () -> odd.even(q::add));
            executor.execute((TestRunnable) () -> odd.odd(q::add));
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.SECONDS);

        System.out.println(new ArrayList<>(q));

        assertEquals(java.util.Arrays.asList(0, 1, 0, 2, 0, 3, 0, 4), new ArrayList<>(q));
    }

    interface TestRunnable extends Runnable {

        void run0() throws InterruptedException;

        @Override
        default void run() {
            try {
                run0();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}