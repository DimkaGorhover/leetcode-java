package org.gd.leetcode.p1114;

import org.gd.leetcode.common.LeetCode;

import java.util.concurrent.CountDownLatch;

@LeetCode(
        difficulty = LeetCode.Level.EASY
)
class Foo {

    private final CountDownLatch l1, l2;

    public Foo() {
        l1 = new CountDownLatch(1);
        l2 = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        l1.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        l1.await();
        printSecond.run();
        l2.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        l2.await();
        printThird.run();
    }
}
