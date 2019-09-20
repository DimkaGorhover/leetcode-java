package org.gd.leetcode.p1115;

import org.gd.leetcode.common.LeetCode;

import java.util.concurrent.Semaphore;

/**
 * https://leetcode.com/problems/print-foobar-alternately
 */
@LeetCode(difficulty = LeetCode.Level.MEDIUM, tags = LeetCode.Tags.CONCURRENCY)
class FooBar {

    private final Semaphore foo = new Semaphore(1);
    private final Semaphore bar = new Semaphore(0);

    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            foo.acquire();
            printFoo.run();
            bar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            bar.acquire();
            printBar.run();
            foo.release();
        }
    }
}
