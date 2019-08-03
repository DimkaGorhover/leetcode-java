package org.gd.leetcode.p1116;

import org.gd.leetcode.common.LeetCode;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * https://leetcode.com/problems/print-zero-even-odd/
 */
@LeetCode(difficulty = LeetCode.Level.MEDIUM)
class Semaphore_ZeroEvenOdd {

    private final int n;

    private final Semaphore zero, odd, even;

    private int count = 1;

    public Semaphore_ZeroEvenOdd(int n) {
        this.n = n;
        zero = new Semaphore(1);
        odd = new Semaphore(0);
        even = new Semaphore(0);
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            if (count > n - 2) break;
            zero.acquire();
            printNumber.accept(0);
            (count % 2 == 0 ? even : odd).release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            if (count >= n) break;
            odd.acquire();
            printNumber.accept(count++);
            zero.release();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            if (count >= n) break;
            even.acquire();
            printNumber.accept(count++);
            zero.release();
        }
    }
}
