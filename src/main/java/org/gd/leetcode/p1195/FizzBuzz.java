package org.gd.leetcode.p1195;

import org.gd.leetcode.common.LeetCode;

import java.util.ConcurrentModificationException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

/**
 * https://leetcode.com/problems/fizz-buzz/
 * https://leetcode.com/problems/fizz-buzz-multithreaded/
 *
 * Write a program that outputs the string representation of numbers from 1 to n, however:
 *
 * If the number is divisible by 3, output "fizz".
 *
 * If the number is divisible by 5, output "buzz".
 * If the number is divisible by both 3 and 5, output "fizzbuzz".
 *
 * For example, for n = 15, we output: 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz.
 *
 * Implement a multithreaded version of FizzBuzz with four threads. The same instance of FizzBuzz will be passed to four different threads:
 *
 * Thread A will call fizz() to check for divisibility of 3 and outputs fizz.
 * Thread B will call buzz() to check for divisibility of 5 and outputs buzz.
 * Thread C will call fizzbuzz() to check for divisibility of 3 and 5 and outputs fizzbuzz.
 * Thread D will call number() which should only output the numbers.
 *
 * @see org.gd.leetcode.p0412.Solution
 * @since 2019-09-19
 */
@LeetCode(difficulty = LeetCode.Level.MEDIUM, tags = LeetCode.Tags.CONCURRENCY)
class FizzBuzz {

    private final AtomicInteger counter;

    private final int n;

    public FizzBuzz(int n) {
        this.n = n;
        counter = new AtomicInteger(1);
    }

    private void updateToNext(int count) {
        if (!counter.compareAndSet(count, count + 1))
            throw new ConcurrentModificationException();
    }

    /**
     * printFizz.run() outputs "fizz".
     */
    public void fizz(Runnable printFizz) throws InterruptedException {
        int count;
        while ((count = counter.get()) <= n) {
            if (count % 3 == 0 && count % 5 != 0) {
                printFizz.run();
                updateToNext(count);
            }
        }
    }

    /**
     * printBuzz.run() outputs "buzz".
     */
    public void buzz(Runnable printBuzz) throws InterruptedException {
        int count;
        while ((count = counter.get()) <= n) {
            if (count % 3 != 0 && count % 5 == 0) {
                printBuzz.run();
                updateToNext(count);
            }
        }
    }

    /**
     * printFizzBuzz.run() outputs "fizzbuzz".
     */
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        int count;
        while ((count = counter.get()) <= n) {
            if (count % 3 == 0 && count % 5 == 0) {
                printFizzBuzz.run();
                updateToNext(count);
            }
        }
    }

    /**
     * printNumber.accept(x) outputs "x", where x is an integer.
     */
    public void number(IntConsumer printNumber) throws InterruptedException {
        int count;
        while ((count = counter.get()) <= n) {
            if (count % 3 != 0 && count % 5 != 0) {
                printNumber.accept(count);
                updateToNext(count);
            }
        }
    }
}
