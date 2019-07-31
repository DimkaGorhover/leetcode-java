package org.gd.leetcode.p1116;

import org.junit.jupiter.api.*;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class ZeroEvenOddTest {

    @Test
    void test() throws InterruptedException {
        var odd = new ZeroEvenOdd(3);
        var q   = new LinkedBlockingQueue<Integer>();

        var executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (int i = 0; i < 5; i++) {
            executor.execute((TestRunnable) () -> odd.zero(q::add));
            executor.execute((TestRunnable) () -> odd.even(q::add));
            executor.execute((TestRunnable) () -> odd.odd(q::add));
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.SECONDS);

        System.out.println(List.copyOf(q));

        assertEquals(List.of(0, 1, 0, 2, 0, 3), List.copyOf(q));
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