package org.gd.leetcode.p1116;

import org.gd.leetcode.common.LeetCode;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

@LeetCode(difficulty = LeetCode.Level.MEDIUM)
class ZeroEvenOdd {

    private final Semaphore zero = new Semaphore(2);
    private final Semaphore even = new Semaphore(1);
    private final Semaphore odd  = new Semaphore(1);

    private final AtomicInteger counter = new AtomicInteger(1);

    private final int n;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        if (counter.get() < n) {
            zero.acquire(2);
            printNumber.accept(0);
            even.release(1);
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        int count = this.counter.getAndIncrement();
        if (count < n) {
            even.acquire(1);
            printNumber.accept(count);
            odd.release(1);
            zero.release(1);
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        int count = this.counter.getAndIncrement();
        if (count < n) {
            odd.acquire(1);
            printNumber.accept(count);
            even.release(1);
            zero.release(1);
        }
    }
}
