package org.gd.leetcode.p1116;

import org.junit.jupiter.api.*;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

class ZeroEvenOddTest {

    @Test
    void test() {
        var odd = new ZeroEvenOdd(3);
        var q = new LinkedBlockingQueue<Integer>();

        var executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (int i = 0; i < 10; i++) {
            executor.execute((TestRunnable) () -> odd.zero(q::add));
            executor.execute((TestRunnable) () -> odd.even(q::add));
            executor.execute((TestRunnable) () -> odd.odd(q::add));
        }

        System.out.println(q);

        executor.shutdown();
        while (!executor.isTerminated());

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
        };
    }
}