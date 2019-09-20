package org.gd.leetcode.p1116;

import org.gd.leetcode.common.LeetCode;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

/**
 * https://leetcode.com/problems/print-zero-even-odd/
 */
@LeetCode(difficulty = LeetCode.Level.MEDIUM, tags = LeetCode.Tags.CONCURRENCY)
class ZeroEvenOdd {

    private static final int
            LAST_ODD  = 1,
            LAST_EVEN = 1 << 1,
            LAST_ZERO = 1 << 2;

    private int n;

    private final AtomicInteger
            count = new AtomicInteger(0),
            c     = new AtomicInteger(LAST_EVEN);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        synchronized (this) {
            while (count.get() < n) {
                if ((c.get() & LAST_ZERO) == 0) {
                    printNumber.accept(0);
                    c.set(c.get() | LAST_ZERO);
                    notifyAll();
                } else {
                    wait();
                }
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        synchronized (this) {
            while (count.get() < n) {
                if (c.compareAndSet((LAST_ZERO | LAST_ODD), LAST_EVEN)) {
                    printNumber.accept(count.incrementAndGet());
                    notifyAll();
                } else {
                    wait();
                }
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        synchronized (this) {
            while (count.get() < n) {
                if (c.compareAndSet((LAST_ZERO | LAST_EVEN), LAST_ODD)) {
                    printNumber.accept(count.incrementAndGet());
                    notifyAll();
                } else {
                    wait();
                }
            }
        }
    }
}
