package org.gd.leetcode.p1195;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class FizzBuzz1 {

    private final int n;
    private final Semaphore fizzbuzzSem, fizzSem, buzzSem, numberSem;
    private int i;

    FizzBuzz1(int n) {
        this.n = n;
        this.i = 1;
        this.fizzbuzzSem = new Semaphore(0);
        this.fizzSem = new Semaphore(0);
        this.buzzSem = new Semaphore(0);
        this.numberSem = new Semaphore(1);
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (i <= n) {
            fizzSem.acquire();
            printFizz.run();
            i++;
            numberSem.release();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (i <= n) {
            buzzSem.acquire();
            printBuzz.run();
            i++;
            numberSem.release();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (i <= n) {
            fizzbuzzSem.acquire();
            printFizzBuzz.run();
            i++;
            numberSem.release();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {

        while (i <= n) {
            numberSem.acquire();
            if (i % 3 == 0 && i % 5 == 0)
                fizzbuzzSem.release();
            else if (i % 3 == 0)
                fizzSem.release();
            else if (i % 5 == 0)
                buzzSem.release();
            else {
                printNumber.accept(i);
                i++;
            }
        }

    }
}
